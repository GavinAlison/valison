package com.alison.base.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeDemo<T> {

	ToolUtils<T>[][] key;

	T[][] param;

	// 泛型方法的定义，
	// 是否拥有泛型方法，与其所在的类是否泛型类没有关系。泛型是先定义后使用的
	// 要定义泛型方法，只需将泛型参数列表置于返回值前。如:
	public <T> void method1(T t) {
		System.out.println(t.getClass().getName());
	}

	public static void method01() {
		System.out.println("-------------------");
		// 以下是泛型数组
		try {
			Type type = TypeDemo.class.getDeclaredField("key").getGenericType();
			GenericArrayType arrayType = (GenericArrayType) type;
			System.out.println(arrayType.getGenericComponentType());

			Type para = TypeDemo.class.getDeclaredField("param")
					.getGenericType();
			GenericArrayType arrPara = (GenericArrayType) para;
			System.out.println(arrPara.getGenericComponentType());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 泛型表达式, 通配符
	public void method02(List<? extends Pair<T>> list) throws Exception {
		Method method = TypeDemo.class.getMethod("method02", List.class);
		Type[] upperBounds = null;
		Type[] lowerBounds = null;
		Type[] types = method.getGenericParameterTypes();
		for (Type type : types) {
			Type[] actualTypeArguments = ((ParameterizedType) type)
					.getActualTypeArguments();
			for (Type acType : actualTypeArguments) {
				WildcardType wildcardType = (WildcardType) acType;
				upperBounds = wildcardType.getUpperBounds();
				lowerBounds = wildcardType.getLowerBounds();
				System.out.println("通配符表达式类型是：" + Arrays.asList(wildcardType));
				if (upperBounds.length != 0) {
					System.out.println("表达式上边界：" + upperBounds[0]);
				}
				if (lowerBounds.length != 0) {
					System.out.println("表达式下边界：" + lowerBounds[0]);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TypeDemo d = new TypeDemo();
		// d.method1(new String("asd"));
		ToolUtils<Integer> t = new ToolUtils<Integer>();
		t.setParam(12);
		// 特点 ：1. 实现的时候，设置该泛型类型，可以在编译时期避免传入不需要的类型值
		// 如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
		// 2. 在使用的时候，不需要进行类型转换
		// 3. 可以定义泛型方法， 可以定义多个泛型
		System.out.println(t.getParam());
		try {
			d.method02(new ArrayList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 1:把泛型定义在类上 <br>
 * 2:类型变量定义在类上,方法中也可以使用<br>
 * 用户想要使用哪种类型，就在创建的时候指定类型。 <br>
 * 使用的时候，该类就会自动转换成用户想要使用的类型了。<br>
 * 为什么可以定义在类上，因为类的关键字Class,每个类都会对应一个java.lang.Class对象，
 * Class实现了genericDeclaration的接口，该接口定义了，只要实现该接口， 就可以在实体上定义/声明泛型变量(TypeVariable)。
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