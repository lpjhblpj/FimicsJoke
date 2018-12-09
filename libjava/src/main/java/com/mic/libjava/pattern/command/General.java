package com.mic.libjava.pattern.command;

/**
 * 将军听从皇帝的指令 Command
 */
public class General {

    private Command undoCommand;
    private Command attackCommand;


    public General()
    {

        Soldier soldier=new Soldier();
        Army army=new Army(soldier);
        undoCommand=new UndoCommand(army);
        attackCommand =new AttachCommand(army);
    }

    public void attach()
    {
        attackCommand.excute();
    }
    public  void  undo()
    {
        undoCommand.back();
    }

}
