package com.alison.base;

public class TypeDemo {
	// 泛型方法的定义，
	// 是否拥有泛型方法，与其所在的类是否泛型没有关系。泛型是先定义后使用的
	// 要定义泛型方法，只需将泛型参数列表置于返回值前。如:
	public <T> void method1(T t) {
		System.out.println(t.getClass().getName());
	}

	public static void main(String[] args) {
		// TypeDemo d = new TypeDemo();
		// d.method1(new String("asd"));
		ToolUtils<Integer> t = new ToolUtils<Integer>();
		t.setParam(12);
		// 如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
		System.out.println(t.getParam());

	}
}

/**
 * 1:把泛型定义在类上 <br>
 * 2:类型变量定义在类上,方法中也可以使用<br>
 * 用户想要使用哪种类型，就在创建的时候指定类型。 <br>
 * 使用的时候，该类就会自动转换成用户想要使用的类型了。
 * 
 * 
 * @author hy
 * @param <T>
 */
class ToolUtils<T> {
	private T param;

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

}