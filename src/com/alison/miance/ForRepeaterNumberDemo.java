package com.alison.miance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 求出给定数组或者字符串中重复出现N次的元素 <br>
 * 使用泛型的类型变量，用他进行存储值
 * 
 * 
 * 1. 初始化数组元素时，元素类型使用泛型T，<br>
 * 2. 需要提供一个泛型数组的方法getGenericTypeArr()<br>
 * 3. 在创建泛型数组之后，初始化 数组initArr
 * 
 * @author hy
 * 
 */
public class ForRepeaterNumberDemo<T> {
	/**
	 * 需要定义存储泛型数组的方法为 定义一个泛型类，里面管理Object[]数组，每次将T的对象存储到Object[] 数组中,<br>
	 * 取出的时候，强制转换一下<br>
	 */
	// 管理泛型数组的元素
	private Object[] dataElement;

	private static int size = 10;
	// 实际大小，用于快速失败机制
	private int modCount = 0;

	public void add(T t) {
		if (dataElement == null) {
			dataElement = new Object[size];
		}
		ensureCapacity(modCount + 1);
		dataElement[modCount] = t;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) dataElement[index];
	}

	// 扩容
	public void ensureCapacity(int minCapacity) {
		modCount++;
		int oldCapacity = dataElement.length;
		if (minCapacity > oldCapacity) {
			Object[] oldData = dataElement;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			dataElement = Arrays.copyOf(dataElement, newCapacity);
		}
	}

	// 泛型数组
	public T[] genericArr;

	public ForRepeaterNumberDemo(int size) {
		this.size = size;
	}

	public ForRepeaterNumberDemo() {
	}

	public ForRepeaterNumberDemo(Class<T> type) {
		this(type, arrLength);
		initArr(genericArr);
	}

	/**
	 * 生成泛型数组的方法
	 * 
	 * @param type
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public ForRepeaterNumberDemo(Class<T> type, int size) {
		if (size == 0) {
			size = ForRepeaterNumberDemo.size;
		}
		genericArr = (T[]) java.lang.reflect.Array.newInstance(type, size);
	}

	public T[] getGenericTypeArr() {
		return genericArr;
	}

	public void addByGenericArr(T t) {
		genericArr[genericArr.length + 1] = t;
	}

	public T getByGenericArr(int index) {
		return (T) genericArr[index];
	}

	private final static int N = 15;

	// 数组的长度
	private static final int arrLength = 5000;
	// 值数组的长度
	private static final int valueLength = 500;
	// 生成随机函数的变量
	private static Random random = new java.util.Random();

	// 如果给定的是数组, 这个数组的类型一般为int[], byte[], Long[], Float[], Double[], String[]
	// 赋值
	public void initArr(T[] t) {
		Object[] origin = (Object[]) t;
		for (int i = 0; i < arrLength; i++) {
			// TODO现在无法将值存储到arr数组中
			// 思路，T[]数组中的元素类型是T, 但是无法往存储T类型的数组，最起码在编译无法判断，
			// 只能先存储到Object[]中，然后通过强类型转换
			origin[i] = random.nextInt(valueLength) + 1;
		}
		t = (T[]) origin;
	}

	// 泛型方法, 这里只是接受包装类型
	public <T> void method1(T t) {
		System.out.println(t.getClass().getName());
	}

	public static void main(String[] args) {
		ForRepeaterNumberDemo<Integer> f = new ForRepeaterNumberDemo<Integer>(
				Integer.class);
		// System.out.println(f.getGenericTypeArr());
		// for(int i : f.getGenericTypeArr()){
		// System.out.print(i+",");
		// }
		f.byMap(f.getGenericTypeArr());

	}

	public <T> void byMap(T[] arr) {
		Map<T, Integer> map = new HashMap<T, Integer>();
		for (int i = 0; i < arrLength; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]).intValue() + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		int j = 0;
		for (Map.Entry<T, Integer> entry : map.entrySet()) {
			// 输出重复次数大于num的元素
			if (entry.getValue().intValue() > N) {
				System.out
						.print(entry.getKey() + ":" + entry.getValue() + ", ");
				j++;
				if (j % 6 == 0) {
					System.out.println();
				}
			}
		}
	}
}
