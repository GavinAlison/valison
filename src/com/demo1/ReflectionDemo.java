package com.demo1;

public class ReflectionDemo {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.demo1.ReflectionDemo");
		ReflectionDemo d = (ReflectionDemo) clazz.newInstance();
	}
}
