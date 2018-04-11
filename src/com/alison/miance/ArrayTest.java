package com.alison.miance;

import java.util.Random;

/**
 * 求出数组中重复次数大于num的数值<br>
 * 一个int[] , length =5000, 数组元素取值范围: 0-500<br>
 * 思路： map, 数组,
 * 
 * @author hy
 * 
 */
public class ArrayTest {
	// 原数组的长度
	private static final int arrLength = 5000;
	// 值数组的长度
	private static final int valueLength = 500;
	// 重复次数变量
	private static final int num = 15;
	// 生成随机函数的变量
	private static Random random = new java.util.Random();

	/**
	 * 存储数据的数组
	 */
	private static int[] arr = new int[arrLength];

	/**
	 * 存储重复的数组
	 */
	private static int[] countArr = new int[valueLength];

	public ArrayTest() {
		initArr();
	}

	public void initArr() {
		for (int i = 0; i < arrLength; i++) {
			arr[i] = random.nextInt(valueLength);
		}
	}

	public void printArr(int[] arr) {
		for (int i = 0; i < arrLength; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	/**
	 * 求出数组中重复次数大于num的数值<br>
	 * 一个int[] , length =5000, 数组元素取值范围: 0-500<br>
	 * 思路： map, 数组,
	 */
	public void method01() {
		for (int i = 0; i < arrLength; i++) {
			int temp = arr[i];
			countArr[temp]++;
			// System.out.print("countArr[" + temp + "]=" + countArr[temp] +
			// "");
		}
		for (int i = 0; i < valueLength; i++) {
			if (countArr[i] > num) {
				System.out.print("countArr[" + i + "]:" + countArr[i] + ",");
			}
		}
	}

	public static void main(String[] args) {
		ArrayTest a = new ArrayTest();
		a.printArr(arr);
		System.out.println();
		System.out.println("------------");
		a.method01();
		System.out.println();
	}
}
