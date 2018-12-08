package com.mic.libjava.pattern.factorymethod;

public class ExportExcelOperator extends ExportOperate {

	@Override
	public ExportFileApi newFileApi() {
		return new ExportExcelFile();
	}

}
