package com.alison.spring.ioc.stereoMixedconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:com/alison/spring/ioc/stereoMixedconfig/cd-config.xml")
public class SoundSystemConfig {

}
