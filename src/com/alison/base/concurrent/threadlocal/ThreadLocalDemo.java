package com.alison.base.concurrent.threadlocal;

public class ThreadLocalDemo {

	@SuppressWarnings("unchecked")
	public static ThreadLocal t1 = new ThreadLocal();

	public static void main(String[] args) {
		if (ThreadLocalDemo.t1.get() == null) {
			System.out.println("当前线程从未放过值。");
			t1.set("value");
		}
		// 如果在存放值呢, 取出来的是哪个值, 结果是 取出来的是 最后存放的值
		t1.set("asd");
		System.out.println(t1.get());
	}
}
