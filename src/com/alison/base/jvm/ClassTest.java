package com.alison.base.jvm;

public class ClassTest {
	/**
	 * 由于Class文件结构决定了定义类，接口，方法，变量的名称长度不能超过2^16-1=65535 The type generates a
	 * string that requires more than 65535 bytes to encode in Utf8 format in
	 * the constant pool
	 */
	public String str = "";
}
