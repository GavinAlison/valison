package com.alison.jvm.t1;

public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		// 在jdk1.7中，String.intern()并不会将"计算机软件"字符串复制到方法区的常量池中， 还是引用堆内存中的数据
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		// jdk1.7中，方法区（永久代）的常量池含有java字符，而str2指向的是堆内存中的地址,
		// str2.intern()指向的是常量池中的地址
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
}
