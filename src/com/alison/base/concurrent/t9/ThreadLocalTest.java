package com.alison.base.concurrent.t9;

public class ThreadLocalTest extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Thread{" + Thread.currentThread().getName()
					+ "},counter=" + MultiThreadObject.getNextInteger());
		}
	}

}
