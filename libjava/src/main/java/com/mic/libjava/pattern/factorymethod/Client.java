package com.mic.libjava.pattern.factorymethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class Client {

	@Test
	public  void main() {
		String data = "我的数据";
		ExportDBOperator op = new ExportDBOperator();
		op.export(data);
		
		ExportExcelOperator op2 = new ExportExcelOperator();
		op2.export(data);
		
		//List Creator 
		//ArrayList ConcreteCreator具体的创建者
		List<String> list = new ArrayList<String>();
		list.iterator();
		
		//Iterator Product 
		//ArrayListIterator ConcreteProduct具体的产品
		
	}

}
