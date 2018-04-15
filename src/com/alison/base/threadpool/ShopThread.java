package com.alison.base.threadpool;

/**
 * 消费者
 * 
 * @author hy
 * 
 */
public class ShopThread extends Thread {

	private Product product;

	public ShopThread(Product p) {
		product = p;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在消费值-"+product.pop());
	}
}
