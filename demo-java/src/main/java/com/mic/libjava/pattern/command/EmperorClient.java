package com.mic.libjava.pattern.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EmperorClient {


    @Test
    public void Test(){
        General general=new General();
        general.attach();
        general.undo();
    }
}
