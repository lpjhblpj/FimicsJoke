package com.mic.libjava.pattern.simplefactory;


public class ColorClient {

    public static void main(String args[]){

        IColorApi colorApi=Factory.create(Factory.COLOR.BLUE);
        colorApi.save();

    }


}
