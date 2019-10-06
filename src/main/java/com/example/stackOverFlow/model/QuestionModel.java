package com.example.stackOverFlow.model;

import javax.persistence.*;

@Entity
public class QuestionModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int question_id;
    private String question;

    public int getQuestion_id() {
        return question_id;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private UserModel user;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
