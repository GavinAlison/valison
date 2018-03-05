package com.alison.base.class9;

public class PropertiesTest {
	/**
	 * 测试将系统的配置信息取出来
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(System.getProperties().get("file.separator"));
		System.out.println("Java运行环境的版本:" + System.getProperty("java.version"));
		System.out.println("Java运行环境的生产商:" + System.getProperty("java.vendor"));
		System.out.println("Java的安装路径：" + System.getProperty("java.home"));
		System.out.println("虚拟机实现的版本：" + System.getProperty("java.vm.version"));
		System.out.println("虚拟机实现的生产商：" + System.getProperty("java.vm.vendor"));
		System.out.println("默认的临时文件路径：" + System.getProperty("java.io.tmpdir"));
		System.out.println("用户的账户名称：" + System.getProperty("user.name"));
		System.out.println("当前用户工作目录：" + System.getProperty("user.dir"));
		System.out.println("用户的home路径：" + System.getProperty("user.home"));
		System.out.println("操作系统的名称:" + System.getProperty("os.name"));
		System.out.println("操作系统的版本：" + System.getProperty("os.version"));
		System.out.println("操作系统的架构：" + System.getProperty("os.arch"));
		System.out.println("运行环境规范的名称:"
				+ System.getProperty("java.specification.name"));
		System.out.println("Java类格式化的版本号："
				+ System.getProperty("java.class.version"));
		System.out.println("类所在的路径：" + System.getProperty("java.class.path"));
	}

}
