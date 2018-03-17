package com.alison.base.concurrent.t9;

public class Test {
	public static void main(String[] args) {
		ThreadLocalTest thread1 = new ThreadLocalTest();
		ThreadLocalTest thread2 = new ThreadLocalTest();
		ThreadLocalTest thread3 = new ThreadLocalTest();
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
