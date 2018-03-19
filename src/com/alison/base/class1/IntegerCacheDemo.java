package com.alison.base.class1;

import java.lang.reflect.Field;

public class IntegerCacheDemo {
	public static void main(String[] args) {
		try {
			// 含有Integer.IntegerCache类，里面含有缓存
			Integer a1 = 1;
			Integer a2 = 2;
			System.out.println("a1=" + a1 + ",a2=" + a2);
			swap(a1, a2);
			System.out.println("a1=" + a1 + ",a2=" + a2);
		} catch (Exception e) {

		}
	}

	private static void swap(Integer num1, Integer num2)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		int temp = num1;
		Field field = Integer.class.getDeclaredField("value");
		field.setAccessible(true);
		field.set(num1, num2);// 这里修改缓存cache[temp]中的值为num2.value值
		System.out.println("temp---" + temp);
		System.out
				.println("Integer.valueOf(-128)....." + Integer.valueOf(-128));
		System.out.println("Integer.valueOf(0)....." + Integer.valueOf(0));
		System.out.println("Integer.valueOf(1)....." + Integer.valueOf(1));
		System.out.println("Integer.valueOf(2)....." + Integer.valueOf(2));
		System.out.println("Integer.valueOf(3)....." + Integer.valueOf(3));
		field.set(num2, temp);
	}
}
