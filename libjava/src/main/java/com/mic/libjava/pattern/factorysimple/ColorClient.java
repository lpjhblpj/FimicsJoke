package com.mic.libjava.pattern.factorysimple;


public class ColorClient {

    public static void main(String args[]){

        IColorApi colorApi=Factory.create(Factory.COLOR.BLUE);
        colorApi.save();

        Factory.create(YellowImpl.class);

    }


}
