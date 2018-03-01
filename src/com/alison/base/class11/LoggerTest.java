package com.alison.base.class11;

import java.io.File;
import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerTest {
	/**
	 * 一、创建Logger对象
	 * 
	 * static Logger getLogger(String name) <br>
	 * 为指定子系统查找或创建一个 logger。<br>
	 * static Logger getLogger(String name, String resourceBundleName) <br>
	 * 为指定子系统查找或创建一个 logger。 <br>
	 * 注意：name是Logger的名称，当名称相同时候，同一个名称的Logger只创建一个。 <br>
	 * <br>
	 * 二、Logger的级别 比log4j的级别详细，全部定义在java.util.logging.Level里面。 <br>
	 * 各级别按降序排列如下： <br>
	 * SEVERE（最高值）> WARNING > INFO > CONFIG > FINE > FINER > FINEST（最低值） <br>
	 * 此外，还有一个级别 OFF，可用来关闭日志记录，使用级别 ALL 启用所有消息的日志记录。<br>
	 * logger默认的级别是INFO，比INFO更低的日志将不显示。<br>
	 * Logger的默认级别定义是在jre安装目录的lib下面。<br>
	 * ########<br>
	 * Limit the message that are printed on the console to INFO and above. <br>
	 * java.util.logging.ConsoleHandler.level = INFO <br>
	 * ########<br>
	 * 
	 * @see https://www.cnblogs.com/liaojie970/p/5582147.html
	 * 
	 * 
	 *      ################## logger的名字是有层级关系的。这和log4j的控制方式完全一致
	 * 
	 * 
	 */
	public static void main(String[] args) {
		LoggerTest logObj = new LoggerTest();
		logObj.method03();
	}

	public void method01() {
		Logger log = Logger.getLogger("com.alison.base.class11.LoggerTest");
		log.setLevel(Level.INFO);
		Logger log1 = Logger.getLogger("com.alison.base.class11.LoggerTest");
		System.out.println(log == log1); // true
		Logger log2 = Logger.getLogger("");// 默认的日志管理器LogManager
		log.info("log");// 会记录时间，全类名，方法，第二行是info信息
		log1.info("log1");
		// log2.setLevel(Level.WARNING);// 默认的日志级别是info
		log2.info("info....log2");
		log2.warning("warning....log2");
	}

	public void method02() {
		Logger log = Logger.getLogger("com.alison.base.class11.LoggerTest");
		log.setLevel(Level.INFO);
		Logger log2 = Logger
				.getLogger("com.alison.base.class11.LoggerTest.log");
		// 控制台控制器/处理器
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.INFO);
		log.addHandler(consoleHandler);
		try {
			File file = new File(
					"D:\\workspace\\valison\\src\\com\\alison\\base\\class11\\logTest.log");
			if (!file.exists()) {
				file.createNewFile();
			}
			// 文件控制器
			// 此时没有格式化 format,
			// 文件控制器可以设置本地化，过滤器，格式化
			FileHandler fileHandler = new FileHandler(file.getAbsolutePath());
			fileHandler.setLevel(Level.INFO);
			log.addHandler(fileHandler);
			fileHandler.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("log");
		log2.info("log2信息");
	}

	public void method03() {
		Logger log = Logger.getLogger("com.alison.base.class11.LoggerTest");
		log.setLevel(Level.INFO);
		try {
			File file = new File(
					"D:\\workspace\\valison\\src\\com\\alison\\base\\class11\\logTest1.log");
			if (!file.exists()) {
				file.createNewFile();
			}
			// 文件控制器
			// 此时没有格式化 format,
			// 文件控制器可以设置本地化，过滤器，格式化
			FileHandler fileHandler = new FileHandler(file.getAbsolutePath());
			fileHandler.setLevel(Level.INFO);
			fileHandler.setFormatter(new Formatter() {
				@Override
				public String format(LogRecord record) {
					return record.getLevel() + ":" + record.getMessage() + "\n";
				}
			});
			log.addHandler(fileHandler);
			fileHandler.flush();
			log.info("测试");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
