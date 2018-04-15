package com.alison.base.jvm;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class TestPermGen {
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
			Method getLog = logfClass.getMethod("getLog", String.class);
			Object result = getLog.invoke(logfClass, "TestPermGen");
			insList.add(result);
			System.out.println(i + ": " + result);
		}
	}

	private static URL[] getURLS() throws Exception {
		URL url = Thread.currentThread().getContextClassLoader().getResource(
				"/lib/commons-logging-1.1.jar");
		System.out.println(url);
		System.out.println(new File(url.toURI()));
		InputStream libDir = TestPermGen.class
				.getResourceAsStream("/WebRoot/WEB-INF/lib/commons-logging-1.1.jar");
		System.out.println(libDir);
		// File[] subFiles = libDir.listFiles();
		File[] subFiles = null;
		int count = subFiles.length;
		URL[] urls = new URL[count];
		for (int i = 0; i < count; i++) {
			urls[i] = subFiles[i].toURI().toURL();
		}
		return urls;
	}
}
