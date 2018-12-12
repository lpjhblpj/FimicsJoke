package com.mic.libjava.pattern.state;
/**
 * �ٿص�����
 * @author Administrator
 *
 */
public class TvControlNomral {

	private  final static int POWER_ON=1;

	private final static int POWER_OFF=2;
	
	public int mState=POWER_OFF;
	/**
	 * ����
	 */
	public void powerOn()
	{
		mState=POWER_ON;
		if(mState==POWER_OFF)
		{
			System.out.println("�����ˣ�����Կ�������");
		}else {
			System.out.println("�Ѿ���������Ч");
		}
	}
	
	/**
	 * �ػ�
	 */
	public void powerOff()
	{
		mState=POWER_OFF;
		if(mState==POWER_ON)
		{
			System.out.println("powerOff");
			
		}else {
			System.out.println("powerOff");
		}
	}
	/**
	 * �л�Ƶ��
	 */
	public void nextChannel()
	{
		if(mState==POWER_ON)
		{
			System.out.println("nextChannel");
			
		}
		
	}
	
	public void preChannel()
	{
		if(mState==POWER_ON)
		{
			System.out.println("preChannel");
		}
	}
}
