package com.alison.spring.ioc.stereoJavaconfig;

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

	@Bean
	public CompactDisc compactDisc() {
		return new SgtPeppers();
	}

	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {
		return new CDPlayer(compactDisc);
	}

}
