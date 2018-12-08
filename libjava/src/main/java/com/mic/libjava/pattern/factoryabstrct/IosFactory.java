package com.mic.libjava.pattern.factoryabstrct;

public class IosFactory implements IFactory {
    @Override
    public IApi create() {
        return new IosApi();
    }
}
