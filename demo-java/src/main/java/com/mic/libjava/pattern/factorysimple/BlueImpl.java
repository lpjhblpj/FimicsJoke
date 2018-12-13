package com.mic.libjava.pattern.factorysimple;

/**
 * 最少知识原则，这里不要写成public的
 */
class BlueImpl implements IColorApi {
    @Override
    public void save() {
      System.out.print(this.getClass().getSimpleName()+"save");
    }

    @Override
    public void restore() {
        System.out.print(this.getClass().getSimpleName()+"restore");
    }
}
