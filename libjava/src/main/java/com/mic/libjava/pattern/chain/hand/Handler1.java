package com.mic.libjava.pattern.chain.hand;

public class Handler1 extends Handler{

	@Override
	public void handle(AbstractRequest abstractRequest) {
		System.out.println("----handle1  处理请求: ");
	}

	@Override
	public boolean onIntercept() {
		return false;
	}


}
