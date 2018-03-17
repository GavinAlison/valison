package com.alison.base.concurrent.t1;

public class ThreadQuestion implements Runnable {
	int b = 100;

	synchronized void m1() throws InterruptedException {
		b = 1000;
		Thread.sleep(500);// 6
		System.out.println(Thread.currentThread().getName() + ", b=" + b);
	}

	synchronized void m2() throws InterruptedException {
		Thread.sleep(250);// 5
		b = 2000;
	}

	@Override
	public void run() {
		try {
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadQuestion tt = new ThreadQuestion();
		Thread t = new Thread(tt);// 1
		t.start();// 2

		tt.m2();// 3

		System.out.println("main thread b = " + tt.b);// 4
	}
}
