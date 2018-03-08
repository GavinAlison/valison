package com.alison.base.concurrent.t8;

public class Run1 {
	public static void main(String[] args) {
		Run1 r1 = new Run1();
		System.out.println("begin.." + System.currentTimeMillis());
		// r1.method01();
		r1.method02();
		System.out.println("end  .." + System.currentTimeMillis());

	}

	public void method01() {
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
	}

	public void method02() {
		MyThread1 m1 = new MyThread1();
		m1.start();
	}
}
