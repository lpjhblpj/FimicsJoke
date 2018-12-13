package com.mic.libjava.pattern.factoryabstrct;

public class AndroidFactory implements IFactory {
    @Override
    public IApi create() {
        return new AndroidApi();
    }
}
