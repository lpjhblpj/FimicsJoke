package com.mic.libjava.pattern.command;

public class UndoCommand   implements Command {
	private Army army;
	
	
	public UndoCommand(Army army) {
		this.army = army;
	}

	@Override
	public void excute() {
		army.undo();
	}

	@Override
	public void back() {
		army.back();
	}

}
