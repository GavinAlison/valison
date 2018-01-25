package com.alison.base.class10;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ResourceTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame jframe = new ResourceTestFrame();
				jframe.setTitle("resourcetest");
				jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jframe.setVisible(true);
			}
		});
	}
}

class ResourceTestFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	public ResourceTestFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// 重点: getClass().getResource("about.gif");
		URL aboutURL = getClass().getResource("about.gif");
		Image img = new ImageIcon(aboutURL).getImage();
		setIconImage(img);

		JTextArea textArea = new JTextArea();
		// 重点: getClass().getResourceAsStream("about.txt");
		InputStream is = getClass().getResourceAsStream("about.txt");
		Scanner sc = new Scanner(is);
		while (sc.hasNext()) {
			textArea.append(sc.nextLine() + "\n");
			add(textArea);
		}
	}

}
