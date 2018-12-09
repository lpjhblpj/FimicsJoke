package com.mic.libjava.pattern.observer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Client {

	    @Test
		public  void test() {
			ConcreteSubject subject=new ConcreteSubject();
			Observer observer1=new ConcreteObserver("observer1");
			Observer observer2=new ConcreteObserver("observer2");
			Observer observer3=new ConcreteObserver("observer3");
			subject.attach(observer1);
			subject.attach(observer2);
			subject.attach(observer3);
			subject.notifyObservers();
		}
}
