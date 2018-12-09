package com.mic.libjava.pattern.Interoreter;

public abstract class OperatorExpression extends ArithmeticExpression {
	public ArithmeticExpression expression1,expression2;

	public OperatorExpression(ArithmeticExpression expression1,
			ArithmeticExpression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}
	
	
	
	
}
