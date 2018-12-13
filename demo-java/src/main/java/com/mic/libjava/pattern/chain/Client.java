package com.mic.libjava.pattern.chain;


import com.mic.libjava.pattern.chain.hand.AbstractRequest;
import com.mic.libjava.pattern.chain.hand.Handler;
import com.mic.libjava.pattern.chain.hand.Handler1;
import com.mic.libjava.pattern.chain.hand.Handler2;
import com.mic.libjava.pattern.chain.hand.Handler3;
import com.mic.libjava.pattern.chain.hand.XRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class Client {

	@Test
	public  void Test() {
		//确定链式关系
		Handler handler1=new Handler1();
		Handler handler2=new Handler2();
		Handler handler3=new Handler3();
		handler1.nextHandler=handler2;
		handler2.nextHandler=handler3;
		
		AbstractRequest xRequest=new XRequest("网络请求");
		
		handler1.handleRequest(xRequest);
	}
}
