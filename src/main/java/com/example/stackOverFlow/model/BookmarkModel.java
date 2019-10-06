package com.example.stackOverFlow.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints =@UniqueConstraint(columnNames={"user_id","answer_id"}) )
public class BookmarkModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int bookmark_id;

    public int getBookmark_id() {
        return bookmark_id;
    }
//   boolean bookmarkValue;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private UserModel user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="answer_id")
    private AnswerModel answer;

//    public boolean isBookmarkValue() {
//        return bookmarkValue;
//    }
//
//    public void setBookmarkValue(boolean bookmarkValue) {
//        this.bookmarkValue = bookmarkValue;
//    }

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
