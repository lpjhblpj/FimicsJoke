package com.mic.libjava.pattern.Interoreter;

public class NumberExpression extends ArithmeticExpression{
	private int num;
	 
	public NumberExpression(int num) {
		this.num = num;
	}

	@Override
	public int interpret() {
		return num;
	}

}
