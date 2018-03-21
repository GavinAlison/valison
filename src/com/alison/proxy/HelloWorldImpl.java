package com.alison.proxy;

/**
 * 目标对象
 * 
 * @author hy
 * 
 */
public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("hello world!");
	}

}
