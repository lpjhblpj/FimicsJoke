package com.mic.libjava.concurrency;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TreadClient {

    @Test
    public void test(){
        ThreadPool.threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.print("--------------");
            }
        });
    }
}
