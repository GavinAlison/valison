package com.alison.spring.ioc.t2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Autowired顾名思义，就是自动装配，其作用是为了消除代码Java代码里面的<br>
 * getter/setter与bean属性中的property。当然 ，getter看个人需求，<br>
 * 如果私有属性需要对外提供的话，应当予以保留。<br>
 * 
 * @author hy
 * @since 20180325
 */
public class Zoo {
	@Autowired
	private Tiger tiger;
	@Resource
	private Monkey monkey;

	@Override
	public String toString() {
		return "Zoo [monkey=" + monkey + ", tiger=" + tiger + "]";
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/alison/spring/ioc/t2/spring_module.xml");
		System.out.println(ctx);
	}
}
