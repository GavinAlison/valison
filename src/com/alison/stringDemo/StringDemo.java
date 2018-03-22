package com.alison.stringDemo;

public class StringDemo {
	public static void main(String[] args) {
		String greeting = "HELP!中国";
		System.out.println(greeting.codePointCount(0, greeting.length()));
		System.out.println("-----------------------------");
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer(sb.append("a"));
		StringBuffer sb2 = sb.append("b");
		@SuppressWarnings("unused")
		StringBuffer sb3 = sb.append("a");
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println("-----------------------------");
		

	}
}
