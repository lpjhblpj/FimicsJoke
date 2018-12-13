package com.mic.libjava.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *抽象主题(被观察者)
 */
public class AbstractSubject {

	private List<Observer> list=new ArrayList<>();
	

	public void attach(Observer observer)
	{
		list.add(observer);
		
	}

	public void detach(Observer observer)
	{
		list.remove(observer);
	}

	public  void notifyObservers()
	{
		for(Observer observer:list)
		{
			observer.update();
		}
	}
}
