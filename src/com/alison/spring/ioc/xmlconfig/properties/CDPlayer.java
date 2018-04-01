package com.alison.spring.ioc.xmlconfig.properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.alison.spring.ioc.xmlconfig.CompactDisc;
import com.alison.spring.ioc.xmlconfig.MediaPlayer;

public class CDPlayer implements MediaPlayer {
	private CompactDisc compactDisc;

	@Autowired
	public void setCompactDisc(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}

	public void play() {
		compactDisc.play();
	}

}
