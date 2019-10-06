package com.example.stackOverFlow.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints =@UniqueConstraint(columnNames={"user_id","question_id"}) )
public class AnswerModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int answer_id;
    private String answer;

    public int getAnswer_id() {
        return answer_id;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private UserModel user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="question_id")
    private QuestionModel question;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public QuestionModel getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }
}
