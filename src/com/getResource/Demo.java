package com.getResource;

public class Demo {
	/**
	 * 测试class.getResource()与getClass().getClassLoader().getResource()区别
	 * 
	 * java.net.URL class.getResource()
	 * path  不以’/'开头时，默认是从此类所在的包下取资源；
	 * path  以’/'开头时，则是从ClassPath根下获取；
	 * 
	 * 
	 * java.net.URL  Class.getClassLoader().getResource(String path)     
	 * path不能以’/'开头时；
	 * path不能以’/'开头时；
	 * 
	 */
	public static void main(String[] args) {
		Demo d = new Demo();
		System.out.println(Demo.class.getResource(""));
		//java 中: file:/D:/workspace/valison/WebRoot/WEB-INF/classes/com/getResource/
		//web中:   file:/D:.../tomcat/../valison/WEB-INF/classes/com/getResource/
		System.out.println(Demo.class.getResource("/"));
		//java:file:/D:/workspace/valison/WebRoot/WEB-INF/classes/
		//web中:  valison/WEB-INF/classes/
		System.out.println(d.getClass().getClassLoader().getResource(""));
		//java: file:/D:/workspace/valison/WebRoot/WEB-INF/classes/
		//web: valison/WEB-INF/classes/
	}
}
