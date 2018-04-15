package com.alison.base.threadpool;

/**
 * 生产者
 * 
 * @author hy
 * 
 */
public class ProductThread extends Thread {

	private Product product;

	public ProductThread(Product p) {
		product = p;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在生产值-"
				+ product.add());
	}
}
