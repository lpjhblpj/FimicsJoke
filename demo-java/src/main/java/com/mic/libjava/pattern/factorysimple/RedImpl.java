package com.mic.libjava.pattern.factorysimple;

class RedImpl implements IColorApi {
    @Override
    public void save() {
        System.out.print(this.getClass().getSimpleName()+"save");
    }

    @Override
    public void restore() {
        System.out.print(this.getClass().getSimpleName()+"restore");
    }
}
