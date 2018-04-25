package com.alison.base.type;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Java类型之参数化类型
public class ParameterizedTypeDemo implements InterfaceCD {
	private static ParameterizedTypeDemo p = new ParameterizedTypeDemo();

	public static void main(String[] args) throws Exception {
		// p.typeVariable(new ArrayList());
		p.method08();

	}

	// 泛型方法
	public <T> void method01(Class<T> clazz) {

	}

	public void method02() {

	}

	public void method04() throws Exception {
		ParameterizedTypeDemo p = new ParameterizedTypeDemo();
		// 获取方法, 该方法可以取出方法
		Method method = p.getClass().getMethod("method02");
		System.out.println(method);
		// public void com.alison.base.type.ParameterizedTypeDemo.method02()

		Method method1 = p.getClass().getMethod("method01", Class.class);
		System.out.println(method1);
		// 这里的第二个参数，和getRawType()意义类似
		// 获取方法上的泛型参数类型
		Type[] types = method1.getGenericParameterTypes();
		System.out.println(types.length);
		for (Type t : types) {
			System.out.println(t);// java.lang.Class<T>
		}
		Type type = method1.getGenericParameterTypes()[0];
		// type是Type类型，但直接输出的不是具体Type的五种子类型，而是这五种子类型以及WildcardType具体表现形式
		System.out.println(type.getClass().getName());
	}

	public void method05(List list) throws Exception {

		// class.getMethod(String name, Class<?>... parameterTypes)
		// 这里的参数类型只能传递方法签名中的参数的类型，不能传递参数的子类或者实现类的类型， 如果传递了，那么提示找不到noSuchMethod
		Method m = ParameterizedTypeDemo.class.getMethod("method05",
				ArrayList.class);
		// ✖
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
		// 这里只能传递List.class类型， 不能传递子类ArrayList.class
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
		System.out.println(t1[0]);// interface java.util.List
		System.out.println(t2[0]);// java.util.List<java.lang.String>
		// 我们通过　getGenericParameterTypes 得到的是 List<String>，
		// 那么我们怎么能得到它的参数化类型的实例呢
		// type 还有好多子接口，我们通过子接口来操作
		System.out.println(t2.getClass());
		// 将类型向参数化类型转换
		ParameterizedType paramType = (ParameterizedType) t2[0];
		System.out.println(paramType.getClass());
		// 可以得到参数化类型的参数实例, 就是去掉<>后面的，里面的类型
		System.out.println(paramType.getActualTypeArguments()[0]);
		// sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl

	}

	public void method06() {
		ParameterizedTypeDemo p = new ParameterizedTypeDemo();
		// p.method03(new ArrayList<String>());
		// p.method05(new ArrayList());
		System.out.println(new String().getClass().getSuperclass());// class
		// java.lang.Object
		System.out.println(new Integer(2).getClass().getSuperclass());// class
		// java.lang.Object
		System.out.println(String.class.getSuperclass());// class
		// java.lang.Object
		String[] arr = new String[20];
		System.out.println(arr.getClass().getSuperclass());// class
		// java.lang.Object
		System.out.println(List.class.getSuperclass());// null
		System.out.println(Object.class.getSuperclass());// null
		System.out.println(p.getClass().getSuperclass());// class
		// java.lang.Object

	}

	public static void convert() {
		List<String> list = new ArrayList<String>();
		// 当前对象的直接超类的 Type, 实际为ArrayList类的超类
		Type type = list.getClass().getGenericSuperclass();
		System.out.println("type:" + type);
		ParameterizedType pt = (ParameterizedType) type;
		System.out.println("pt.getActualTypeArguments()[0]:"
				+ pt.getActualTypeArguments()[0]);// type:java.util.AbstractList<E>

		Integer[] array = new Integer[10];
		System.out.println("isArray:" + array.getClass().isArray());// true
		Type t1 = array.getClass().getGenericSuperclass();
		System.out.println(t1);// class java.lang.Object
		// GenericArrayType pt2 = (GenericArrayType)t1;
	}

	public static void relations() {
		Type types = Class.class.getGenericSuperclass();
		System.out.println(types);// class java.lang.Object
	}

	@SuppressWarnings("unchecked")
	public static void typeTest() {
		Type t1 = Integer.class;
		System.out.println(t1);// class java.lang.Integer
		Type t2 = String.class;
		System.out.println(t2);// class java.lang.String
		Type t3 = int[].class;
		System.out.println(t3);// class [I
		Type t4 = int[][].class;
		System.out.println(t4);// class [[I
		Type t5 = Class.class;
		System.out.println(t5);// class java.lang.Class
		Class t6 = Class.class;
		System.out.print(t6);// class java.lang.Class
	}

	public static void typeVariable(List<Date> list) {
		// class java.util.ArrayList
		System.out.println(list.getClass());
		TypeVariable tval[] = list.getClass().getTypeParameters();
		TypeVariable v = tval[0];
		Type t[] = v.getBounds();
		System.out.println(t.length);// 1
		System.out.println(v.getGenericDeclaration().getTypeParameters()[0]);// E

		/*
		 * System.out.println(tval.length); for(TypeVariable val:tval)
		 * System.out.println(val);
		 */
	}

	@Override
	public void testB() {

	}

	// getRawTy(), 返回最外层<>前面那个类型，即Map<K ,V>的Map
	@SuppressWarnings("unchecked")
	public void method07() {
		Map<Integer, String> maps = new HashMap<Integer, String>();
		ParameterizedType pType = (ParameterizedType) maps.getClass()
				.getGenericSuperclass();// 获得HashMap的父类, 获取实际对象的父类
		System.out.println(pType);// java.util.AbstractMap<K, V>
		System.out.println(pType.getRawType());// class java.util.AbstractMap
		if (pType.getRawType() instanceof Class) {
			System.out.println("true");// true
		}
		// 注意类型（Type）与类（Class）的区别
	}

	// getOwnerType 获得这个类型的所有者的类型
	public void method08() throws Exception {
		Method method = new ParameterizedTypeDemo().getClass().getMethod(
				"applyMethod", Map.Entry.class);
		Type[] types = method.getGenericParameterTypes();
		ParameterizedType pType = (ParameterizedType) types[0];
		// 返回所有者类型，打印结果是interface java.util.Map
		System.out.println(pType.getOwnerType());
		// Map接口就是Map.Entry的所有者
	}

	public static <T, U> void applyMethod(Map.Entry<T, U> mapEntry) {
	}
}
