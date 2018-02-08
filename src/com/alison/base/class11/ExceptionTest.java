package com.alison.base.class11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionTest {

	private ExceptionTest() {
	}

	private static ExceptionTest instance = new ExceptionTest();

	public static ExceptionTest getInstance() {
		return ExceptionTest.instance;
	}

	public static void main(String[] args) {
		int returnValue = ExceptionTest.getInstance().method04();
		System.out.println(returnValue);

	}

	/*
	 * 必须声明已检查异常，否则编译器会报错
	 */
	public void method1() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("asd");
	}

	/*
	 * 对于未检查异常，要么是错误error，不可控制；要么避免发生，可以对其进行catch操作。
	 */
	public void method02() {
		try {
			String str = null;
			str.charAt(1);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 如何抛出一个异常, 创建异常 new Exception(); throw new Exception();<br>
	 * 抛出多个异常，再次抛出异常与异常链
	 */
	public void method03() {
		try {
			throw new Exception("exception");
		} catch (Exception e) {

		}
	}

	/**
	 * finally子句表示最终需要执行的语句. <br>
	 * try和finally中含有return语句. <br>
	 * finally会覆盖try中的return返回值
	 */
	public int method04() {
		int n = 2;
		try {
			int r = n * n;
			return r;
		} finally {
			if (n == 2)
				// 此时会覆盖try中的return语句
				return n;
		}
	}

	/**
	 * 待资源的try语句.<br>
	 * 待资源的try语句中本身就含有try...catch语句<br>
	 * Java7几乎把所有的“资源类”（包括文件IO的各种类，JDBC编程的Connection、Statement等接口……）进行了改写，
	 * 改写后的资源类都实现了AutoCloseable或Closeable接口<br>
	 * ------<br>
	 * 被自动关闭的资源必须实现Closeable或AutoCloseable接口。<br>
	 * （Closeable是AutoCloseable的子接口， Closeeable接口里的close ()方法声明抛出了IOException;<br>
	 * AutoCloseable接口里的close()方法声明抛出了Exception） 被关闭的资源必须放在try语句后的圆括号中声明、初始化。<br>
	 * 如果程序有需要自动关闭资源的try语句后可以带多个catch块和一个finally块。
	 */
	public void method05() throws IOException {
		// 该方法在myeclipse8.6不支持，因为myeclipse8.6的jdk Complier level最高为jdk 1.6
		// 而带资源的try语句只支持jdk1.7的编译器
		// try(Scanner in = new Scanner(new
		// FileInputStream("com/alison/base/class11/1.txt"))){
		// while(in.hasNext()){
		// System.out.println(in.next());
		// }
		// }
	}
}
