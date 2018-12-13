package com.mic.libjava.pattern.chain.hand;

public abstract class Handler {
	public Handler nextHandler;
	public  void handleRequest(AbstractRequest abstractRequest) {

		//如果拦截了就走自己的handle方式
		if(this.onIntercept())
		{
			handle(abstractRequest);
		}else {
			//沒攔截就走下个handler的处理方法
			if(nextHandler!=null)
			{
				nextHandler.handleRequest(abstractRequest);
			}else {
				this.handle(abstractRequest);
			}
			
		}
	}
	/**
	 * 每个处理者的对象的具体处理方式
	 * @param abstractRequest
	 */
	public abstract void handle(AbstractRequest abstractRequest);

	public abstract boolean onIntercept();

}
