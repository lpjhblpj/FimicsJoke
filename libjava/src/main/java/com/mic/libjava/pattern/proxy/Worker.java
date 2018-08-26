package com.mic.libjava.pattern.proxy;

public class Worker implements IBank{

    private IBank iBank;

    public Worker(IBank iBank) {
        this.iBank = iBank;
    }

    @Override
    public void applyCard() {

        if(iBank!=null){
            System.out.print("代理开卡");
            iBank.applyCard();
        }
    }

    @Override
    public void loseCard() {
        if(iBank!=null){
            System.out.print("代理挂失卡");
            iBank.loseCard();
        }
    }
}
