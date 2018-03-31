package com.alison.spring.ioc.autoconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用注解形式RunWith的形式去加载， 不用手动加载ApplicationContext上下文容器
//底层自动帮你注册好了
@RunWith(SpringJUnit4ClassRunner.class)
// 这里的classPath是从根文件中查找
@ContextConfiguration(locations = "classpath*:com/alison/spring/ioc/autoconfig/config/spring-module.xml")
public class MyJunitTest {
	@Autowired
	private CDPlayer cd;

	@Test
	public void test01() {
		cd.play();
	}
}
