package com.alison.spring.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:com/alison/spring/ioc/oo/config/spring-module.xml" })
public class BaseJunitTest {
	
}
