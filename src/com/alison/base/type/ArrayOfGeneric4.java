package com.alison.base.type;

import java.lang.reflect.Array;

//这个例子来自http://developer.51cto.com/art/201202/317813.htm的例子<br>
//讲述的是如何创建一个泛型数组, 
// 感觉这是将泛型数组作为该类的元素，进行维护，然后可以
//通过java.lang.reflect.Array.newInstance(Class, count)创建该泛型数组
public class ArrayOfGeneric4<T> {
	T[] ts;

	@SuppressWarnings("unchecked")
	public ArrayOfGeneric4(Class<T> type, int size) {
		// to solution array of generic key code!
		ts = (T[]) Array.newInstance(type, size);
	}

	public T get(int index) {
		return ts[index];
	}

	public void set(int index, T t) {
		// 直接覆盖
		ts[index] = t;
	}

	// 返回泛型数组
	public T[] getRep() {
		return ts;
	}

	public static void main(String[] args) {
		ArrayOfGeneric4<Integer> genericArr = new ArrayOfGeneric4<Integer>(
				Integer.class, 10);
		Object[] objs = genericArr.getRep();
		for (int i = 0; i < 10; i++) {
			genericArr.set(i, i);
			System.out.print(genericArr.get(i) + ",");
		}
		System.out.println();
		try {
			Integer[] strs = genericArr.getRep();
			System.out
					.println("user Array.newInstance to create generci of array was successful!!!!! ");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
