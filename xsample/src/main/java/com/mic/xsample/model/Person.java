package com.mic.xsample.model;

public class Person {

    private String name;
    private int age;

    // 默认的构造方法
    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}