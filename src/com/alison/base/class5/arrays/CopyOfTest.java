package com.alison.base.class5.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * this program demonstrates the use of reflection for manipulation arrays.
 * 
 * @author Created by hy 2017-12-15 1:58
 * 
 */
public class CopyOfTest {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		a = (int[]) goodCopyOf(a, 10);
		System.out.println(Arrays.toString(a));

		String[] b = { "Tom", "Dick", "Harry" };
		b = (String[]) goodCopyOf(b, 10);
		System.out.println(Arrays.toString(b));

		try {
			System.out
					.println("the following call will generate an exception.");
			b = (String[]) badCopyOf(b, 10);
		} catch (Exception e) {
			System.out.println("badCopyOf is not good copy method, because "
					+ e.getMessage());
		}
		new CopyOfTest().method2();

	}

	/**
	 * this method attempts to grow an array by allocating a new array and
	 * copying all elements. <br>
	 * 就是浅拷贝数组对象，不是对数组增加长度，浅拷贝的对象的类型由原类型变成Object[]
	 * 
	 * @param a
	 *            the array to grow
	 * @param newLength
	 *            the new length
	 * @return a larger array that contains all elements of a. However, the
	 *         returned array has type Object[], not the same type as a
	 */
	public static Object[] badCopyOf(Object[] a, int newLength) {
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}

	/**
	 * 编写泛型数组,--使用反射 This method attempts to grow an array by allocating a new
	 * array and copying all elements. <br>
	 * 
	 * @param a
	 * @param newLength
	 * @return a larger array that contains all elements of a. However, the
	 *         returned array has type Object[], not the same type as a<br>
	 *         返回的必须是Object[]的类型对象
	 */
	public static Object goodCopyOf(Object a, int newLength) {
		Class cl = a.getClass();
		if (!cl.isArray())
			return null;
		// getComponentType返回数组的Class对象,
		// 为什么是数组的Class对象呢？
		// 所有的JAVA类都继承自object,那数组也不例外。
		// 就是说一个数组本身就是一个class,你得到这个数组的CLASS对象后，可以把它转型为数组。
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		// 通过Array.newInstance(Class<?>, int)创建新数组
		Object newArray = Array.newInstance(componentType, length);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}

	/**
	 * cl.getComponentType所创建的数组对象与原来的数组对象是否相等<br>
	 * 1. 不相等， cl.getComponentType的类型是Class, int[] a 的类型是int[]<br>
	 * 2. 每个对象都对应着一个Class对象，可以通过a.getClass()获得。而cl.getComponetType获得数组Class类型对象
	 * 通过结果可以得到，cl.getCompnonetType().getName()的结果是数组的单个元素的类型
	 */
	public void method2() {
		int[] a = new int[] { 1, 2, 3 };
		Class cl = a.getClass();
		System.out.println("ArrayClass: " + cl);
		System.out.println("ArrayName: " + cl.getName());
		Class componentType = cl.getComponentType();
		System.out.println("component: " + componentType);
		System.out.println("componentName: " + componentType.getName());
	}

}
