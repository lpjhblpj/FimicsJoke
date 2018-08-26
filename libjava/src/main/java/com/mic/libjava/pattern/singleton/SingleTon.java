package com.mic.libjava.pattern.singleton;

public class SingleTon {


    private  SingleTon(){}

    private static class Holder{
        private static final SingleTon instance = new SingleTon();
    }


    public static SingleTon getInstance(){
        return Holder.instance;
    }
}
