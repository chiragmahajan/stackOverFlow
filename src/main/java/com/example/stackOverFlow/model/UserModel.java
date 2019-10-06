package com.example.stackOverFlow.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class UserModel {
    public int getUser_id() {
        return user_id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int user_id;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
