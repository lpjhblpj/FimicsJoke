package com.mic.libjava.pattern.protypeclone;

public class Client {

	public static void main(String[] args) {
		OrderDealFactory orderDealFactory=new OrderDealFactory();
		PersonOrder order=new PersonOrder();
		order.setOderNumber(3500);
		order.setOrderName("个人订单");
		orderDealFactory.dealOrder(order);
	}
}
