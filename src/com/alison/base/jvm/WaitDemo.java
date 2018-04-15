package com.alison.base.jvm;

// TODO待处理
public class WaitDemo {
	public static void createlockThread(final Object lock) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						System.out.println("wait before!");
						lock.wait();
						System.out.println("wait after!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "waitdemo");
		thread.start();
	}

	public static void main(String[] args) {
		Object lock = new Object();
		createlockThread(lock);
		// synchronized(lock){
		lock.notify();
		// }
	}

}
