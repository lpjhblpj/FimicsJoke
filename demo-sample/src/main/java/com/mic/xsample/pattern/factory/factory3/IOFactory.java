package com.mic.xsample.pattern.factory.factory3;

/**
 * 生成类的工厂接口
 * Created by hcDarren on 2017/9/24.
 */
public interface IOFactory {
    IOHandler createIOHandler(Class<? extends IOHandler> ioHandlerClass);
}
