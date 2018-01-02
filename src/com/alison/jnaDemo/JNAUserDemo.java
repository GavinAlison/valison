package com.alison.jnaDemo;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;

public class JNAUserDemo {

	private static String dll_name = "JNativeCpp";

	public static void main(String[] args) throws NativeException,
			IllegalAccessException {
//		System.out.println(System.getProperty("java.classpath"));
		// DLL中的Add函数是实现了两个整形数相加。
		// 1、首先创建JNative对象：
		JNative jnative = new JNative(dll_name, "GetStringPlatformChars"); // 创建一个JNative对象。用来调用dll
		// 2、设置返回值类型：
		jnative.setRetVal(Type.INT);// 设置dll中对应的函数返回值 ，为空则设置为Type.VOID
		int i = 0;
		// 3.设置参数
		jnative.setParameter(i, 6);// 第一个参数为6,没有设置类型，int默认是Type.INT, string
		// 默认为Type.STRING
		++i;
		jnative.setParameter(i, 100);// 第二个参数为100
		// 4、执行
		jnative.invoke(); // 执行dll中的函数
		// 5、获取返回值
		System.out.print(jnative.getRetValAsInt());// 获取返回值并显示
	}

	public void method01() throws Exception {
		// DLL中的Add函数是实现了两个整形数相加。
		// 1、首先创建JNative对象：
		JNative jnative = new JNative(dll_name, "Add"); // 创建一个JNative对象。用来调用dll
		// 2、设置返回值类型：
		jnative.setRetVal(Type.INT);// 设置dll中对应的函数返回值 ，为空则设置为Type.VOID
		int i = 0;
		// 3.设置参数
		jnative.setParameter(i, 6);// 第一个参数为6,没有设置类型，int默认是Type.INT, string
		// 默认为Type.STRING
		++i;
		jnative.setParameter(i, 100);// 第二个参数为100
		// 4、执行
		jnative.invoke(); // 执行dll中的函数
		// 5、获取返回值
		System.out.print(jnative.getRetValAsInt());// 获取返回值并显示
	}

}
