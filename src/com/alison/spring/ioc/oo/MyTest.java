package com.alison.spring.ioc.oo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//不使用注解，默认的Runner加载器去运行
//通过加载上下文ApplicationContext实例
public class MyTest {
	@Test
	public void test01() {
		String resource = "com/alison/spring/ioc/oo/config/spring-module.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		CDPlayer cd = (CDPlayer) ctx.getBean("CDPlayer");
		cd.method();
	}
}
