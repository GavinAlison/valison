package com.alison.spring.ioc.mixedconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

// 在javaconfig中引入XML配置
@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:com/alison/spring/ioc/mixedconfig/cd-config.xml")
public class SoundSystemConfig {

}
