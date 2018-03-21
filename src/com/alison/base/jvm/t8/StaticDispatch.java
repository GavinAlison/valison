package com.alison.base.jvm.t8;

/**
 * 静态分派的例子<br>
 * static是静态的，属于类所有，在编译期的时候，就分派了方法的调用入口，确定了调用哪个方法
 * 
 * @author hy
 * 
 */
public class StaticDispatch {
	static class Human {

	}

	static class Man extends Human {
	}

	static class Woman extends Human {
	}

	public static void sayHello(Human guy) {
		System.out.println("hello guy!");
	}

	public static void sayHello(Man guy) {
		System.out.println("hello man!");
	}

	public static void sayHello(Woman guy) {
		System.out.println("hello woman!");
	}

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatch.sayHello(man);// hello guy!
		StaticDispatch.sayHello(woman);// hello guy!
	}
}
