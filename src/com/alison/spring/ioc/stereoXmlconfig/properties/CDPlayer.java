package com.alison.spring.ioc.stereoXmlconfig.properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.alison.spring.ioc.soundsystem.CompactDisc;
import com.alison.spring.ioc.soundsystem.MediaPlayer;

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
