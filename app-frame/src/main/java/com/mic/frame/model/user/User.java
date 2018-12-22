package com.mic.frame.model.user;

public class User {
    public int id;
    public String name;
    public String password;


    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
