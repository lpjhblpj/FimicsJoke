package com.mic.libjava.pattern.command;
/**
 *
 */
public class Army {
	private Soldier soldier;
	
	public Army(Soldier soldier) {
		super();
		this.soldier = soldier;
	}
	
	public void attack()
	{
		soldier.setAttach("Army attack");
		System.out.println("Army attack");
		
	}
	
	public void back()
	{
		soldier.setBack("Army back");
		System.out.println("Army back");
	}

	public void undo()
	{
		soldier.setBack("Army undo");
		System.out.println("Army undo");
	}
	
}
