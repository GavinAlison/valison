package com.alison.spring.ioc.soundsystem;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//指定spring集成
@RunWith(SpringJUnit4ClassRunner.class)
// 指定要加载的配置文件的位置
@ContextConfiguration(locations = { "classpath*:com/alison/spring/ioc/soundsystem/soundsystem.xml" })
public class Test {

	public void method1() {
		Fs
	}
}
