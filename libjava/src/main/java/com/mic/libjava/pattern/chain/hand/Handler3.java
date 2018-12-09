package com.mic.libjava.pattern.chain.hand;

public class Handler3   extends Handler {

	@Override
	public void handle(AbstractRequest abstractRequest) {
		System.out.println("----handle3  处理请求: ");
	}

	@Override
	public boolean onIntercept() {
		return false;
	}


}