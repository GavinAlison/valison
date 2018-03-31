package com.alison.spring.ioc.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这里相当于一个xml
 * 
 * @author hy
 * 
 */
@Configuration
public class CDPlayerConfig {

	// 告诉spring会返回一个对象，该对象要注册为Spring应用上下文的bean
	@Bean
	public CompactDisc compactDisc() {
		return new SgtPeppers();
	}

	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {
		return new CDPlayer(compactDisc);
	}

}
