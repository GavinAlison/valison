package com.demo;

import org.apache.commons.lang.StringUtils;

public class Demo {

	public static void main(String[] args) {
		Demo d = new Demo();
		d.method02();
	}

	void method01() {
		System.out.println("method01....");
	}

	void method02() {
		// String str1 = "05";
		// @SuppressWarnings("unused")
		// String str2 = "10";
		// System.out.println(Integer.valueOf(str1));
		// System.out.println(String.valueOf(Integer.valueOf(str1)));
		System.out.println(StringUtils.leftPad("100", 2, "0"));

	}
}
