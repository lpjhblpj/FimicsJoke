package com.mic.libjava.pattern.iterator;
/**
 * @param <T>
 */
public interface Iterator<T> {

	boolean hasNext();
	
	
	T next();
}
