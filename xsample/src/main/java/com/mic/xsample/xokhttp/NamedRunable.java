package com.mic.xsample.xokhttp;

public abstract class NamedRunable implements Runnable {
    @Override
    public void run() {
        exexute();
    }


    protected abstract void exexute();


}
