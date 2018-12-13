package com.mic.libjava.pattern.chain.hand;

public class Handler2 extends Handler {

	@Override
	public void handle(AbstractRequest abstractRequest) {
		System.out.println("----handle2  处理请求: ");
	}

	@Override
	public boolean onIntercept() {
		return true;
	}


}
