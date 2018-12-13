package com.mic.libjava.pattern.factorymethod;

public class ExportFileOperator extends ExportOperate{

	@Override
	public ExportFileApi newFileApi() {
		return new ExportTextFile();
	}
	
}
