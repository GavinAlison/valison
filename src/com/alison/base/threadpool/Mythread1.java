package com.alison.base.threadpool;

/**
 * 生产者
 * 
 * @author hy
 * 
 */
public class Mythread1 extends Thread {

	private Product product;

	public Mythread1(Product p) {
		product = p;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在生产值-"
				+ product.add());
	}
}
