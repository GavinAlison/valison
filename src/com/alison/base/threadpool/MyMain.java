package com.alison.base.threadpool;

/**
 * 测试
 * 
 * @author hy
 * 
 */
public class MyMain {

	public static void main(String[] args) {
		// 一个线程不能2次或者多次调用start方法，因为thread底层源码调用start方法中，会先判断thread的threadStatus，
		// 而调用一次之后，threadStatus改变，为!=0，只有threadStatus==0才可以调用
		Product product = new Product();
		Thread t11 = new Mythread1(product);
		Thread t12 = new Mythread1(product);
		Thread t13 = new Mythread1(product);
		Thread t14 = new Mythread1(product);
		Thread t15 = new Mythread1(product);
		Thread t16 = new Mythread1(product);
		Thread t21 = new Mythread2(product);
		Thread t22 = new Mythread2(product);
		Thread t23 = new Mythread2(product);
		Thread t24 = new Mythread2(product);
		Thread t25 = new Mythread2(product);
		t11.start();
		t12.start();
		t13.start();
		t14.start();
		t15.start();
		t16.start();
		t21.start();
		t22.start();
		t23.start();
		t24.start();
		t25.start();

	}
}
