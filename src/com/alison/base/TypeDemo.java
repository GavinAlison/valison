package com.alison.base;

public class TypeDemo {
	// 泛型方法的定义，
	// 是否拥有泛型方法，与其所在的类是否泛型没有关系。要定义泛型方法，只需将泛型参数列表置于返回值前。如:
	public <T> void method1(T t) {
		System.out.println(t.getClass().getName());
	}

	public static void main(String[] args) {
		TypeDemo d = new TypeDemo();
		d.method1(new String("asd")); 
	}
}
