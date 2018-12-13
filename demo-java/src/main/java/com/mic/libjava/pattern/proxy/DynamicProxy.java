package com.mic.libjava.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{

    private IBank iBank;

    public DynamicProxy(IBank iBank) {
        this.iBank = iBank;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println("代理执行   "+method.getName());
        Object obj =method.invoke(iBank,objects);

        return obj;
    }
}
