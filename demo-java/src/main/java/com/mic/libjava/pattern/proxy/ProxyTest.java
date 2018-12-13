package com.mic.libjava.pattern.proxy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Proxy;

@RunWith(MockitoJUnitRunner.class)
public class ProxyTest {

    //静态代理
    @Test
    public void testStaticProxy(){
        Person person = new Person();
        Worker worker = new Worker(person);
        worker.applyCard();
        worker.loseCard();
    }

    @Test
    public void testDynamicPorxy(){
        Person person = new Person();
        IBank proxy = (IBank) Proxy.newProxyInstance(
                IBank.class.getClassLoader(),
                new Class[]{IBank.class},
                new DynamicProxy(person));
        proxy.applyCard();
        proxy.loseCard();
    }
}
