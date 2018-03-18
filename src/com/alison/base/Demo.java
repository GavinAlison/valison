package com.alison.base;

import com.alison.base.class5.inheritance.Employee;

public class Demo {
	final int a = 1;
	final int b = 2;
	final String str = "asd";
	final Employee e = new Employee();
//	final volatile int i = 1;

	public static void main(String[] args) {
		// a = 2;// error, Cannot make a static reference to the non-static
		// field a
		// str = "qwe";error, Cannot make a static reference to the non-static
		// field a
		// e = new Employee();
		// a = b;
		
	}
}
