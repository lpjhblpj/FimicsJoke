package com.mic.libjava.pattern.singleton;

public class InnnerClassSingle {
	private InnnerClassSingle()
	{
		
	}
	private static class SingleHodler{
		private static final InnnerClassSingle instance=new InnnerClassSingle();
	}

	public static InnnerClassSingle getInstance()
	{
		return SingleHodler.instance;
	}
}
