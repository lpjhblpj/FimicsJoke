package com.mic.libjava.pattern.singleton;

public class SingleNotEmptyEasy {
	private static SingleNotEmptyEasy instanceEasy;
	
	public static synchronized  SingleNotEmptyEasy getInstance()
	{
		if(instanceEasy==null)
		{
			instanceEasy=new SingleNotEmptyEasy();
		}
		return instanceEasy;
	}
}
