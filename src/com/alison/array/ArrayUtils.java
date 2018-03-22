package com.alison.array;

import java.util.List;

public class ArrayUtils {
	@SuppressWarnings("unchecked")
	public static void foreach(List list) {
		for (Object obj : list) {
			System.out.print(obj + "  ");
		}
		System.out.println();
	}

	public static void foreach(String[] arr) {
		for (String str : arr) {
			System.out.print(str + "  ");
		}
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	public static void foreachBase(List list) {
		int[] _arr = (int[]) list.get(0);
		foreach(_arr);
	}

	public static void foreach(int[] arr) {
		for (int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

	public static void foreach(Integer[] int_arr) {
		for (int i : int_arr) {
			System.out.print(i + "  ");
		}
		System.out.println();

	}

	/**
	 * 不定长参数，可以不传递值
	 * 
	 * @param a
	 * @param is
	 */
	public void method01(int a, int... is) {
		int sum = a;
		for (int tem : is) {
			sum += tem;
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		ArrayUtils u = new ArrayUtils();
		u.method01(2);
	}

}
