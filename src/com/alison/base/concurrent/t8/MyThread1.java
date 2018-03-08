package com.alison.base.concurrent.t8;

public class MyThread1 extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("this.run threadname="
					+ this.currentThread().getName() + " begin");
			System.out.println("Thread.run threadname="
					+ Thread.currentThread().getName() + " begin");
			this.sleep(2000);
			System.out.println("thread.run threadname="
					+ Thread.currentThread().getName() + " begin");
			System.out.println("this.run threadname="
					+ this.currentThread().getName() + " end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
