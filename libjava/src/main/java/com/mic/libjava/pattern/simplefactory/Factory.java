package com.mic.libjava.pattern.simplefactory;

public class Factory {


    public enum COLOR{
        YELLOW,RED,BLUE
    }


    public static IColorApi create(COLOR color){
        switch (color){
            case YELLOW:
                return new YellowImpl();
            case RED:
                return new RedImpl();
            case BLUE:
                return new BlueImpl();
        }
        return new YellowImpl();
    }
}
