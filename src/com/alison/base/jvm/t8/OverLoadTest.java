package com.alison.base.jvm.t8;

import java.io.Serializable;

/**
 * 静态分派中还有自动类型转换，自动装箱，自动徐照装箱的实现类<br>
 * 这就是重载的本质
 * 
 * @author hy
 * 
 */
public class OverLoadTest {
	public static void sayHello(Object arg) {
		System.out.println(" hello object ");
	}

	public static void sayHello(int arg) {
		System.out.println(" hello int ");
	}

	public static void sayHello(long arg) {
		System.out.println(" hello long ");
	}

	public static void sayHello(float arg) {
		System.out.println(" hello float ");
	}

	public static void sayHello(double arg) {
		System.out.println(" hello double ");
	}

	public static void sayHello(Character arg) {
		System.out.println(" hello Character ");
	}

	public static void sayHello(char arg) {
		System.out.println(" hello char ");
	}

	public static void sayHello(char... arg) {
		System.out.println(" hello char... ");
	}

	public static void sayHello(Serializable arg) {
		System.out.println(" hello Serializable ");
	}

	public static void main(String[] args) {

	}

}
