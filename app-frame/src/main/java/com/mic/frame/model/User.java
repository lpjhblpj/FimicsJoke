package com.mic.frame.model;

public class User {
    public int id;
    public String name;
    public int age;
    public String password;

    public User(int age) {
        this.age = age;
    }

    public User(int id, String name, int age, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
