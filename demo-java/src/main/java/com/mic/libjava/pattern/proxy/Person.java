package com.mic.libjava.pattern.proxy;

public class Person implements IBank {

    @Override
    public void applyCard() {
        System.out.println("   本人开卡");
    }

    @Override
    public void loseCard() {
      System.out.println("  本人挂失卡");
    }
}
