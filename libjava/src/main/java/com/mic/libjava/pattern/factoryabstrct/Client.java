package com.mic.libjava.pattern.factoryabstrct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Client {

    @Test
    public void test(){
        IFactory iFactory = new AndroidFactory();
        iFactory.create().show();
    }
}
