package com.alison.base.class11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
	public static void main(String[] args) {

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

}
