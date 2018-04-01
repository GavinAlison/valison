package com.alison.spring.ioc.mixedconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 指定对应的javaconfig类进行配置
@ContextConfiguration(locations = "classpath*:com/alison/spring/ioc/mixedconfig/cdplayer-config.xml")
public class TestDemo {
	@Autowired
	private MediaPlayer player;

	@Test
	public void play() {
		player.play();
	}
}
