package com.mic.libjava.pattern.template;

public abstract class Game {
	   abstract void initialize();
	   abstract void startPlay();
	   abstract void endPlay();
	   
	   
	   public final void play()
	   {
		   	  System.out.println("��Ϸ����");

		      initialize();


		      startPlay();


		      endPlay();
		      
		      System.out.println("��Ϸ�ػ�");
		   
	   }
}
