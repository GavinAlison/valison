package com.alison.miance;

import java.util.Random;

/**
 * 求出给定数组或者字符串中重复出现N次的元素
 * 
 * @author hy
 * 
 */
public class ForRepeaterNumberDemo {
	private final static int N = 15;

	// 数组的长度
	private static final int arrLength = 5000;
	// 值数组的长度
	private static final int valueLength = 500;
	// 生成随机函数的变量
	private static Random random = new java.util.Random();

	// 如果给定的是数组, 这个数组的类型一般为int[], byte[], Long[], Float[], Double[], String[]
	// 赋值
	public <T> void initArr(Class<T>[] arr) {
		for (int i = 0; i < arrLength; i++) {
			// arr[0].getClass().getName()
			// if (arr[0].getTypeParameters()) {

			// }
		}
	}

	// 泛型方法, 这里只是接受包装类型
	public <T> void method1(T t) {
		System.out.println(t.getClass().getName());
	}

	public static void main(String[] args) {
	}
}
