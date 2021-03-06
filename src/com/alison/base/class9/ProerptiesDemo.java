package com.alison.base.class9;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 系统的键值对在security/java.policy文件中 <br>
 * java.vm.name<br>
 * properties名为属性映射
 * 
 * 
 * 
 * 
 * @author hy
 * 
 */
public class ProerptiesDemo {
	public static void main(String[] args) {
		new Runnable() {
			@Override
			public void run() {
				PropertiesFrame frame = new PropertiesFrame();
				frame.setVisible(true);
			}
		};
	}
}

class PropertiesFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	private File propertiesFile;
	private Properties settings;

	public PropertiesFrame() {
		// get position, size, title from properties
		// 获得系统默认的user.home的key的value
		String userDir = System.getProperty("user.home");
		// File(String parent, String child)
		File propertiesDir = new File(userDir, ".");
		if (!propertiesDir.exists()) {
			propertiesDir.mkdir();
		}
		propertiesFile = new File(propertiesDir, "program.properties");

		Properties defaultSettings = new Properties();
		defaultSettings.put("left", "0");
		defaultSettings.put("top", "0");
		defaultSettings.put("width", "" + DEFAULT_WIDTH);
		defaultSettings.put("height", "" + DEFAULT_HEIGHT);
		defaultSettings.put("title", "");

		// Properties(Properties defaults)
		settings = new Properties(defaultSettings);
		if (propertiesDir.exists()) {
			try {
				FileInputStream in = new FileInputStream(propertiesFile);
				// public synchronized void load(InputStream inStream)
				// 　从输入流中加载一个属性映射
				settings.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int left = Integer.parseInt(settings.getProperty("left"));
		int top = Integer.parseInt(settings.getProperty("top"));
		int width = Integer.parseInt(settings.getProperty("width"));
		int height = Integer.parseInt(settings.getProperty("height"));
		setBounds(left, top, width, height);

		// if no title given , ask user
		String title = settings.getProperty("title");
		if (title.equals("")) {
			title = JOptionPane.showInputDialog("Please supply a frame title.");
		}
		if (title == null) {
			title = "";
		}
		setTitle(title);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				settings.put("left", "" + getX());
				settings.put("top", "" + getY());
				settings.put("width", "" + getWidth());
				settings.put("height", "" + getHeight());
				settings.put("title", getTitle());
				try {
					FileOutputStream out = new FileOutputStream(propertiesFile);

					// public void store(OutputStream out, String comments)
					// 将属性映射存放到一个输出流中
					settings.store(out, "programe Properties");
				} catch (Exception en) {
					en.printStackTrace();
				}
				System.exit(0);
			}
		});
	}
}
