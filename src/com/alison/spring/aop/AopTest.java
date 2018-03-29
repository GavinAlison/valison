package com.alison.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) {
		String xmlPath = "com/alison/spring/aop/aop.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPath);
//		HelloWorldImpl h1 = (HelloWorldImpl) ctx.getBean("h1");
//		HelloWorldImpl2 h2 = (HelloWorldImpl2) ctx.getBean("h2");
//		h1.method1();
	}

}
