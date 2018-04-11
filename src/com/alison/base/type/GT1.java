package com.alison.base.type;

import java.lang.reflect.ParameterizedType;

/**
 * 1. public Type getGenericSuperclass()
 * 
 * 用来返回表示当前Class 所表示的实体（类、接口、基本类型或 void）的直接超类的Type。<br>
 * 如果这个直接超类是参数化类型的，则返回的Type对象必须明确反映在源代码中声明时使用的类型。<br>
 * 如果此Class代表的是Object 类、接口、基本类型或 void，则返回 null。<br>
 * 如果此对象表示一个数组类，则返回表示 Object 类的 Class 对象。<br>
 * 
 * ------<br>
 * 2. public Type[] getGenericInterfaces()
 * 
 * 与上面那个方法类似，只不过Java的类可以实现多个接口，所以返回的Type必须用数组来存储。
 * 
 * 以上两个方法返回的都是Type对象或数组，在我们的这个话题中，Class都是代表的参数化类型，<br>
 * 因此可以将Type对象Cast成ParameterizedType对象。<br>
 * 而 ParameterizedType对象有一个方法， getActualTypeArguments()。
 * 
 * public Type[] getActualTypeArguments()
 * 
 * 用来返回一个Type对象数组，这个数组代表着这个Type声明中实际使用的类型。
 * 
 * @author hy
 * 
 */
public class GT1 extends GT2<Integer> {
	public static void main(String[] args) {
		System.out.println(((ParameterizedType) new GT1().getClass()
				.getGenericSuperclass()));
		System.out.println("--------");
		System.out.println(((ParameterizedType) new GT1().getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}
}
