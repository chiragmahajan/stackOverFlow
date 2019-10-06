package com.example.stackOverFlow.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints =@UniqueConstraint(columnNames={"user_id","answer_id"}) )
public class VoteModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int vote_id;

    public int getVote_id() {
        return vote_id;
    }

    int voteValue;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private UserModel user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="answer_id")
    private AnswerModel answer;

    public int getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(int voteValue) {
        this.voteValue = voteValue;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public AnswerModel getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerModel answer) {
        this.answer = answer;
    }
}
