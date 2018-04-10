package com.alison.miance;

import java.util.Random;

public class ArrayTest {

	private static final int arrLength = 5000;

	private static final int valueLength = 500;

	private static Random random = new java.util.Random();

	/**
	 * 存储数据的数组
	 */
	private static int[] arr = new int[arrLength];

	/**
	 * 存储重复的数组
	 */
	private static int[] countArr = new int[arrLength];

	public void initArr() {
		for (int i = 0; i <= arrLength; i++) {
			arr[i] = (int) random.nextInt(arrLength);
		}
	}

	/**
	 * 求出数组中重复次数大于3的数值<br>
	 * 一个int[] , length =5000, 数组元素取值范围: 0-500<br>
	 * 思路： map, 数组
	 */
	public void method01() {
		for (int i = 0; i < arrLength; i++) {
			int temp = arr[i];

		}
	}
}
