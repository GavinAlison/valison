package com.alison.spring.ioc.t3;

public class EmptyClass {
	static {
		System.out.println("enter emptyClass.static block");
	}

	public EmptyClass() {
		System.out.println("enter emptyClass.construct()");
	}

	public void init() {
		System.out.println("enter emptyClass init()");
	}

	public void destory() {
		System.out.println("enter emptyClass.destorey()");
	}

}
