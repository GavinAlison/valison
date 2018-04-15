package com.alison.base.IntegerDemo;

import org.omg.CORBA.IntHolder;

public class IntegerDemo {
	public static void main(String[] args) {
		Integer el = 100;
		System.out.println("el.intValue()--" + el.intValue());
		System.out.println("Integer.toString(100)--" + Integer.toString(100));
		System.out.println("Integer.toString(100, 2)--"
				+ Integer.toString(100, 2));
		System.out.println("Integer.parseInt('123')--"
				+ Integer.parseInt("123"));
		System.out.println("Integer.parseInt('123', 8)--"
				+ Integer.parseInt("123", 8));
		System.out.println("Integer.valueOf('456')--" + Integer.valueOf("456"));
		System.out.println("-------------------------------------------");
		IntHolder el2 = new IntHolder(100);
		new IntegerDemo().test01(el2);
		System.out.println(el2.value);
	}

	public void test01(IntHolder i) {
		i.value = i.value + 10;
	}
}
