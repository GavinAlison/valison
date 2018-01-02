package com.alison.Property;

//通过System.getProperty("")获取环境变量,详细见readme.txt
public class Properties {
	public static void main(String[] args) {
		//这个加载库时搜索的路径为，应用的jre的路径，再者就是myeclipse自带的jre路径，然后就是path路径了.
//		System.out.print(System.getProperty("jnative.loadNative"));//加载库时搜索的路径列表
		Properties p  = new Properties();
		p.method01();
		
	}
	public void method01(){
		System.out.println("java.version----"+System.getProperty("java.version"));
		System.out.println("java.vendor---"+System.getProperty("java.vendor"));
		System.out.println("java.home---"+System.getProperty("java.home"));
		System.out.println("java.vm.version---"+System.getProperty("java.vm.version"));
		System.out.println("java.vm.vendor---"+System.getProperty("java.vm.vendor"));
		System.out.println("java.io.tmpdir---"+System.getProperty("java.io.tmpdir"));//默认的临时文件路径
		System.out.println("user.name---"+System.getProperty("user.name"));//用户的账户名称
		System.out.println("user.dir---"+System.getProperty("user.dir"));//用户的当前工作目录
		System.out.println(System.getProperty("user.home"));//用户的主目录
		System.out.println(System.getProperty("os.name"));//操作系统的名称
		System.out.println(System.getProperty("os.version"));//操作系统的版本
		System.out.println(System.getProperty("os.arch"));//操作系统的架构
		System.out.println(System.getProperty("java.specification.name"));//运行环境规范的名称
		System.out.println(System.getProperty("java.class.version"));//Java类格式化的版本号
		System.out.println(System.getProperty("java.class.path"));//类所在的路径，包含所有的类
		System.out.print(System.getProperty("java.library.path"));//加载库时搜索的路径列表
	}
}
