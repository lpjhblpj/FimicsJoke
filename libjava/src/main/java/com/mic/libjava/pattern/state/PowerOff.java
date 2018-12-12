package com.mic.libjava.pattern.state;

public class PowerOff implements TVState{

	@Override
	public void nextChannel() {
	}

	@Override
	public void preChannel() {
		
	}

	@Override
	public void turnOn() {
		System.out.println("turnOn");
	}

	@Override
	public void turnOff() {
		System.out.println("turnOff");
	}

}
