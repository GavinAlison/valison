package com.alison.jnaDemo;

//使用的jar包为jna.jar,不是JNative.jar

import com.sun.jna.Library;
import com.sun.jna.Native;

// Simple example of JNA interface mapping and usage. 
public class JNADemo {
	// 编写一个接口，必须继承Library，他要在加载库文件时用
	// This is the standard, stable way of mapping, which supports extensive
	// customization and mapping of Java to native types.
	public interface CLibrary extends Library {
		// 加载库文件，Platform.isWindows()可以判断系统类型
		// 如果是windows,这调用系统自带的动态链接库msvcrt.dll
		// 接口内部需要一个公共静态常量：INSTANCE，通过这个常量，
		// 就可以获得这个接口的实例，从而使用接口的方法，也就是调用外部dll/so的函数。
		/*
		 * 该常量通过Native.loadLibrary()这个API函数获得，该函数有2个参数：<br>
		 * 第一个参数是动态链接库dll/so的名称，但不带.dll或.so这样的后缀， 这符合JNI的规范，因为带了后缀名就不可以跨操作系统平台了。
		 * 搜索动态链接库路径的顺序是 ：<br>
		 * 先从当前类的当前文件夹找，如果没有找到，再在工程当前文件夹下面找win32/win64文件夹，找到后搜索对应的dll文件
		 * ，如果找不到再到WINDOWS下面去搜索 ，再找不到就会抛异常了。<br>
		 * 比如上例中printf函数在Windows平台下所在的dll库名称是msvcrt ，而在其它平台如Linux下的so库名称是c。
		 * 第二个参数是本接口的Class类型。JNA通过这个Class类型，根据指定的.dll/.so文件
		 * ，动态创建接口的实例。该实例由JNA通过反射自动生成。
		 */
		// CLibrary INSTANCE = (CLibrary) Native.loadLibrary(
		// Platform.isWindows() ? "msvcrt" : "c", CLibrary.class);
//		static final File file = new File("src/com/alison//jnaDemo/dll/msvcrt");
		CLibrary INSTANCE = (CLibrary) Native.loadLibrary("msvcrt",
				CLibrary.class);

		// 定义方法，与c语言标准的一致
		// 接口中只需要定义你要用到的函数或者公共变量，不需要的可以不定义，如上例只定义printf函数：
		// 注意参数和返回值的类型，应该和链接库中的函数类型保持一致。
		void printf(String format, Object... args);
	}

	public static void main(String[] args) {
		// 调用,通过对象CLibrary.INSTANCE来调用c语言的printf方法
//		final File file = new File("dll/msvcrt.dll");
//		System.out.println(CLibrary.file.getAbsoluteFile());
		CLibrary.INSTANCE.printf("hello world!\n");
		for (String str : args) {
			CLibrary.INSTANCE.printf("argument: %s\n", str);
		}
		// TestDllInter.INSTANCE.printf("%d", 123);

	}
}
