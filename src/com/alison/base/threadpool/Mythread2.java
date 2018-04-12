package com.alison.base.threadpool;

/**
 * 消费者
 * 
 * @author hy
 * 
 */
public class Mythread2 extends Thread {

	private Product product;

	public Mythread2(Product p) {
		product = p;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在消费值-"+product.pop());
	}
}
