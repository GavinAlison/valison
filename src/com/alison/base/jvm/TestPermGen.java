package com.alison.base.jvm;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Deprecated
/**
 * 失败的例子
 */
public class TestPermGen {

	private static Log log = LogFactory.getLog(TestPermGen.class);

	private static List<Object> insList = new ArrayList<Object>();

	public static void main(String[] args) throws Exception {
		permLeak();
	}

	private static void permLeak() throws Exception {
		for (int i = 0; i < 1000; i++) {
			URL[] urls = getURLS();
			URLClassLoader urlClassloader = new URLClassLoader(urls, null);
			Class<?> logfClass = Class.forName(
					"org.apache.commons.logging.LogFactory", true,
					urlClassloader);
			// Exception in thread "main" java.lang.ClassNotFoundException:
			// org.apache.commons.logging.LogFactory
			// 一直报错， 原因是ClassNotFoundException，说明该Class还没有加载进内存
			// 怎么才能加载进内存，主main内，需要创建该对象，自动加载进内存,
			// 除了创建对象，不知道如何加载进内存，或者是通过ClassLoader方法， 这个怎么加载，不知道

			System.out.println(logfClass);
			Method getLog = logfClass.getMethod("getLog", String.class);
			Object result = getLog.invoke(logfClass, "TestPermGen");
			insList.add(result);
			System.out.println(i + ": " + result);
		}
	}

	private static URL[] getURLS() throws Exception {
		File libDir = new File("E:\\v\\commons-logging");
		File[] subFiles = libDir.listFiles();
		int count = subFiles.length;
		URL[] urls = new URL[count];
		for (int i = 0; i < count; i++) {
			urls[i] = subFiles[i].toURI().toURL();
		}
		return urls;
	}
}
