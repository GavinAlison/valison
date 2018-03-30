package com.alison.spring.ioc.oo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {

	private CompactDisc cd;

	@Autowired(required = true)
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}

	public void method() {
		System.out.println("asdasd");
	}

}
