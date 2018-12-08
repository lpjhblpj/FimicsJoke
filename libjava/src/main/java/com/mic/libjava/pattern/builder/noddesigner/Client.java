package com.mic.libjava.pattern.builder.noddesigner;

public class Client {
	  public static void main(String[] args) {    
		     Room room=(new WorkBuilder()).makeWindow("蓝色玻璃").makeFloor("黄色地板").makeChat("").show();; //获取工人对象   
		     System.out.println(room);;   //工人交房 
		  }  
}
