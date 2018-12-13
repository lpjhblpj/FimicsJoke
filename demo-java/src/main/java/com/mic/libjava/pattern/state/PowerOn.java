package com.mic.libjava.pattern.state;

public class PowerOn  implements TVState{

	@Override
	public void nextChannel() {
		System.out.println("nextChannel");
	}

	@Override
	public void preChannel() {
		System.out.println("preChannel");
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
