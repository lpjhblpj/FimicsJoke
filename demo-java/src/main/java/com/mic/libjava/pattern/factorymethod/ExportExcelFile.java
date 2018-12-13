package com.mic.libjava.pattern.factorymethod;

public class ExportExcelFile implements ExportFileApi {

	@Override
	public void export(String data) {
		System.out.println("Excel表格");
	}

}
