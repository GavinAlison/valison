package com.alison.base.type;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

//Java类型之参数化类型
public class ParameterizedTypeDemo {

	// 泛型方法
	public <T> void method01(Class<T> clazz) {

	}

	public void method02() {

	}

	public static void main(String[] args) throws Exception {
		ParameterizedTypeDemo p = new ParameterizedTypeDemo();
		// 获取方法, 该方法可以取出方法
		Method method = p.getClass().getMethod("method02");
		System.out.println(method);
		// public void com.alison.base.type.ParameterizedTypeDemo.method02()

		Method method1 = p.getClass().getMethod("method01", Class.class);
		System.out.println(method1);
		// 这里的第二个参数，和getRawType()意义类似
		// 获取方法上的泛型参数类型
		// Type[] types = method.getGenericParameterTypes();
		// for (Type t : types) {
		// System.out.println(t);
		// }
	}

	public void method03(List<String> list) throws Exception {
		// 演示得到泛型类中的参数变量的类型
		/*
		 * type 是所有类型的高级公共接口，当然也是Class　的父类 , 它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
		 * 
		 * 先来看一下　Type 的用法 type 是一种表示编程语言中的所有类型的类超级接口，如果　int Integer String
		 * 这都是表示一编程语言的类型，而其中的 int.class Integer.class String.class 它们表示的是类型的实例
		 * 如果，我们前面学习的反射 Class c = Integer.class Class 相当于表示类型的类,而Integer.class
		 * 则是一种 名为整形类型的类型实例　 理解了上面的那些，其　理解 type 就不难了，type 与 class 一样，不过 type
		 * 是一种比　Class 表示范围要广的 超级接口，它表示Java语言中类型的所有接口
		 */
		Method m = ParameterizedTypeDemo.class
				.getMethod("method03", List.class);
		// 其返回是参数的类型
		Type[] t1 = m.getParameterTypes();
		// 其返回的是参数的参数化的类型,里面的带有实际的参数类型
		Type[] t2 = m.getGenericParameterTypes();
		Method m2 = ParameterizedTypeDemo.class.getMethod("main",
				String[].class);
		// 参数里面如果不是参数化类型的话，那么 getGenericParameterTypes就返回与 getParameterTypes 一样　
		Type[] t3 = m2.getGenericParameterTypes();
		Type[] t4 = m2.getParameterTypes();
		System.out.println(t1[0]);
		System.out.println(t2[0]);

	}
}
