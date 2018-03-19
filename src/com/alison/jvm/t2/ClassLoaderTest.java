package com.alison.jvm.t2;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
	public static void main(String[] args) {
		try {
			Object obj = new ClassLoaderTest().new MyClassLoader().loadClass(
					"com.alison.jvm.t2.ClassLoaderTest").newInstance();
			System.out.println(obj.getClass());
			System.out
					.println(obj instanceof com.alison.jvm.t2.ClassLoaderTest);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private class MyClassLoader extends ClassLoader {
		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			try {
				String fileName = name.substring(name.lastIndexOf(".") + 1)
						+ ".class";
				InputStream is = getClass().getResourceAsStream(fileName);
				if (is == null) {
					return super.loadClass(name);
				}
				byte[] b = new byte[is.available()];
				is.read(b);
				// defineClass 方法将一个 byte 数组转换为 Class类的实例
				return defineClass(name, b, 0, b.length);
			} catch (IOException e) {
				throw new ClassNotFoundException(name);
			}
		}
	}
}
