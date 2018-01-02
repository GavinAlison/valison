package com.alison.resourcebundle;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResouceBudleDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"config/applicationContext-resource.xml");
//		String hello = ctx.getMessage("hello", null, Locale.getDefault());
		String hello = ctx.getMessage("hello", null, Locale.US);
		System.out.println(hello);
		
	}
}
