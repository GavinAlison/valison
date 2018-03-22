package com.alison.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayUtil {
	/**
	 * 本类演示了Arrays类中的asList方法 <br>
	 * 通过四个段落来演示,体现出了该方法的相关特性. <br>
	 * 
	 * (1) 该方法对于基本数据类型的数组支持并不好,当数组是基本数据类型时不建议使用 <br>
	 * (2) 当使用asList()方法时，数组就和列表链接在一起了. <br>
	 * 当更新其中之一时，另一个将自动获得更新。 <br>
	 * 注意:仅仅针对对象数组类型,基本数据类型数组不具备该特性<br>
	 * (3) asList得到的数组是的没有add和remove方法的 <br>
	 * 
	 * 阅读相关:通过查看Arrays类的源码可以知道,asList返回的List是Array中的实现的 <br>
	 * 内部类,而该类并没有定义add和remove方法.另外,为什么修改其中一个,另一个也自动 <br>
	 * 获得更新了,因为asList获得List实际引用的就是数组 <br>
	 */
	public static void main(String[] args) {
		// int[] arr_int = { 1, 2, 3, 4 };
		// List list = Arrays.asList(arr_int);
		// ArrayUtils.foreach(list);
		//
		// ArrayUtils.foreachBase(list);
		//
		// Integer[] arr2 = new Integer[] { 1, 2, 3, 4 };
		// List list1 = Arrays.asList(arr2);
		// ArrayUtils.foreach(list1);
		// System.out.println("-----------");
		// String[] str = new String[] { "arr_01", "arr_02", "arr_03", "arr_04",
		// "arr_05" };
		// String[] str1 = new String[] { "arr_01", "arr_02", "arr_03",
		// "arr_04",
		// "arr_05", "arr_06" };
		// new ArrayArrayUtils().sort2(str);
		// ArrayUtils.foreach(str);
		// new ArrayArrayUtils().sort1(str1);

	}

	public void sort2(String[] arr) {
		for (int i = 0; i < arr.length - 1; i += 2) {
			String temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
	}

	@Test
	public void sort1() {

	}

	@SuppressWarnings("unchecked")
	@Test
	public void test01() {
		int[] arr_int = { 1, 2, 3, 4 };
		List list = Arrays.asList(arr_int);
		ArrayUtils.foreach(list);

		ArrayUtils.foreachBase(list);
	}

	@Test
	public void test02() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		for (Integer o : list) {
			System.out.print(o + "-");
		}
		System.out.println();
	}

	/**
	 * 数组copy
	 */
	@Test
	public void test03() {
		int[] arr1 = { 1, 2, 2, 3, 3, 4, 5, 4 };
		// 拷贝数组，增加数组长度
		int[] arr2 = Arrays.copyOf(arr1, arr1.length + 2);
		int[] arr3 = new int[arr1.length];
		ArrayUtils.foreach(arr2);
		System.arraycopy(arr1, 1, arr3, 0, arr1.length - 1);
		ArrayUtils.foreach(arr3);
	}

	@SuppressWarnings("unchecked")
	public static Object goodCopeOf(Object o, int length) {
		Class cl = o.getClass();
		if (!cl.isArray())
			return null;
		Class componentType = cl.getComponentType();
		int newLength = Array.getLength(o);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(o, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}

	@Test
	public void test04() {
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(a));
		a = (int[]) goodCopeOf(a, a.length * 2);
		System.out.println(Arrays.toString(a));
	}

}
