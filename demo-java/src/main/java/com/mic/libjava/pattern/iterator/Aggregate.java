package com.mic.libjava.pattern.iterator;
/**
 */
public interface Aggregate<T> {
	void  add(T  t);
	
	void remove(T t);
	
	Iterator<T> iterator();
	
}
