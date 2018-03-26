package com.alison.spring.ioc.t3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com\\alison\\spring\\ioc\\t3\\bean.xml");
		Person person = (Person) ctx.getBean("person");
		Person person2 = (Person) ctx.getBean("person");
		System.out.println(person == person2);
	}
}
