package com.alison.base.type;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

//返回实体上声明（定义）的所有的类型变量。
public class TypeParametersDemo<K extends ClassA & interfaceB, V> {
	ClassA<K>[][] key;
	V value;

	// 1.在类（Class）上声明（定义）类型变量
	class InnerClassA<T> {
		T t;
	}

	public void method01() {
		// 之后这里可用任意类型替换T，例如
		@SuppressWarnings("unused")
		InnerClassA<String> innerClassA = new InnerClassA<String>();
		// 是否看着有点像集合？不错，集合就是泛型的一个典型运用
	}

	// 2.在方法上声明（定义）
	public static <E> void testGeneric(E e) {
		// 方法上，类型变量声明（定义）不是在参数里边，而且必须在返回值之前,static等修饰后

	}

	// 3.声明（定义）在构造器上
	@SuppressWarnings("hiding")
	public <K> TypeParametersDemo(K k) {

	}

	public TypeParametersDemo() {
	}

	// 【注意】类型变量声明（定义）的时候不能有下限（既不能有super），否则编译报错。为什么？T extends
	// classA表示泛型有上限classA，当然可以，因为这样，每一个传进来的类型必定是classA（具有classA的一切属性和方法），但若是T
	// super classA，传进来的类型不一定具有classA的属性和方法，当然就不适用于泛型，说的具体点：
	// class A<T super InnerClassA>{
	// T t;
	// public void testname() throws Exception {
	// //这个时候你不能用t干任何事，因为你不确定t具有哪些属性和方法
	// //当然，t肯定是有Object方法的，但没意义
	// }
	// }

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TypeParametersDemo d = new TypeParametersDemo();
		d.method02();

	}

	@SuppressWarnings("unchecked")
	public void method02() {
		// 逐个获取该GenericDeclaration的范型变量声明
		TypeVariable[] types = TypeParametersDemo.class.getTypeParameters();
		for (TypeVariable type : types) {
			System.out.println("泛型类型变量名(获得名称，即K、V、E之类名称):" + type.getName());
			System.out.println("获取声明该类型变量实体(即获得类、方法或构造器名):"
					+ type.getGenericDeclaration());
			System.out.println("获得泛型的上限，若未明确声明上边界则默认为Object:"
					+ type.getBounds());
			for (Type t : type.getBounds()) {
				System.out.print("," + t);
			}
			System.out.println();
			System.out.println("--------");
		}
	}

	@SuppressWarnings("unchecked")
	public void method03() {
		Type[] types = TypeParametersDemo.class.getTypeParameters();
		for (Type type : types) {
			TypeVariable t = (TypeVariable) type;
			System.out.println("获取声明该类型变量实体：" + t.getGenericDeclaration());
			System.out.println("获得泛型的上限的最后一个元素："
					+ t.getBounds()[t.getBounds().length - 1]);
			System.out.println(t.getName() + "\n-------------分割线-------------");
		}

	}

}

// 1.在类（Class）上声明（定义）类型变量
class ClassA<K> {
	K k;
}

// 之后这里可用任意类型替换T，例如
interface interfaceB {

}
