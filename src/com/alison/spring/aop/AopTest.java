package com.alison.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"com/alison/spring/aop/aop.xml");
	ApplicationContext ctx2 = new ClassPathXmlApplicationContext(
			"com/alison/spring/aop/aop_2.xml");

	// 目标对象有实现接口，spring会自动选择“JDK代理”
	@Test
	public void testApp() {
		IUserDao userDao = (IUserDao) ctx.getBean("userDao");
		System.out.println(userDao.getClass());// $Proxy6
		userDao.save();
	}

	// 目标对象没有实现接口， spring会用“cglib代理”
	@Test
	public void testCglib() {
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		System.out.println(orderDao.getClass());
		orderDao.save();
	}

	@Test
	public void testAdviceUtil() {
		OrderDao orderDao = (OrderDao) ctx2.getBean("orderDao");
		System.out.println(orderDao.getClass());
		orderDao.save();
	}

	public static void main(String[] args) {
		String xmlPath = "com/alison/spring/aop/aop.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPath);
		// HelloWorldImpl h1 = (HelloWorldImpl) ctx.getBean("h1");
		// HelloWorldImpl2 h2 = (HelloWorldImpl2) ctx.getBean("h2");
		// h1.method1();
	}

}
