package com.alison.base.class7;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @version 1.0 2018-01-09
 * @author hy
 * 
 */
public class SimpleFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class SimpleFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final static int DEFAULT_WIDTH = 300;
	private final static int DEFAULT_HEIGHT = 200;

	public SimpleFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}