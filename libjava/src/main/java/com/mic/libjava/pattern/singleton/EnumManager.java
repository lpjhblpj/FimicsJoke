package com.mic.libjava.pattern.singleton;


/**
 * Enum 默认构造方法是私有的，在反序列化也是安全的
 */
public  enum EnumManager {
	SDCardManager(10)
	{
			
		@Override
		public EnumManager getSingle() {
			return SDCardManager;
		}

		
	}
	,
	HttpManager(1) {
		@Override
		public EnumManager getSingle() {
			return null;
		}
	};
	
	public SdCardImpl getSingleton()
	{
		return new SdCardImpl();
	}
	
	
	public abstract EnumManager getSingle();
	private  EnumManager(int type)
	{
		
	}

}
