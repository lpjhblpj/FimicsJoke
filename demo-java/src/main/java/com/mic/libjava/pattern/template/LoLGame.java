package com.mic.libjava.pattern.template;

public class LoLGame extends Game{

	@Override
	void initialize() {
		System.out.println("��ʼ��Ӣ������");
	}

	@Override
	void startPlay() {
		System.out.println("����з�ս��");
	}

	@Override
	void endPlay() {
		System.out.println("ÿ��Ӯ��ʧ�ܣ��˳���Ϸ");
	}

}
