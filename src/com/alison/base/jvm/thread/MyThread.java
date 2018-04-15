package com.alison.base.jvm.thread;

public class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (true) {
		}
	}

	public static void main(String[] args) {
		MyThread m1= new MyThread("thread-a");
		MyThread m2 = new MyThread("thread-b");
		m1.start();
		m2.start();
	}
}
