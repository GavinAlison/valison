package com.alison.miance;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 求出数组中重复次数大于num的数值<br>
 * 一个int[] , length =5000, 数组元素取值范围: 0-500<br>
 * 思路： map, 数组,<br>
 * 利用数组的思路，时间复杂度为2n<br>
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
		System.out.println("数组元素：");
		for (int i = 0; i < arrLength; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}

	/**
	 * 求出数组中重复次数大于num的数值<br>
	 * 一个int[] , length =5000, 数组元素取值范围: 0-500<br>
	 * 思路： map, 数组,<br>
	 * 1. 数组： 数组元素的值的取值范围确定， 利用这个取值范围建立一个数组newArr<br>
	 * 对原数组orgArr进行遍历， 取出数组的元素值value, 将这个值作为newArr的下标，找到相应的元素，对其进行加1，<br>
	 * 这个遍历了一遍以后，newArr就存储了元素出现的次数， 对newArr进行遍历，就可查找出原数组出现重复次数大于或等于3的次数的元素
	 */
	public void byArray() {
		for (int i = 0; i < arrLength; i++) {
			int temp = arr[i];
			countArr[temp]++;
			// System.out.print("countArr[" + temp + "]=" + countArr[temp] +
			// ",");
		}
		int j = 0;
		System.out.println("数组中出现重复次数大于" + num + "的元素为：");
		for (int i = 0; i < valueLength; i++) {
			if (countArr[i] > num) {
				j++;
				// System.out.print("countArr[" + i + "]:" + countArr[i] + ",");
				System.out.print("元素" + i + "的次数为:" + countArr[i] + ",");
				if (j % 6 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println();
	}

	public void byMap() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arrLength; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]).intValue() + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		int j = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			// 输出重复次数大于num的元素
			if (entry.getValue().intValue() > num) {
				System.out
						.print(entry.getKey() + ":" + entry.getValue() + ", ");
				j++;
				if (j % 6 == 0) {
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayTest a = new ArrayTest();
		// a.printArr(arr);
		// System.out.println("------------");
		a.byMap();
	}

}
