package com.alison.base.jvm.t8;

/**
 * 动态分派， 只有在运行时才知道对象的实际类型<br>
 * 判断这个方法是静态分派还是动态分派，主要看这个方法是属于类所有，还是实例所有。 <br>
 * 编译器可以确定静态方法，不能确定实例方法。
 * 
 * 
 * @author hy
 * 
 */
public class PolymorphicTest {

	public void method01(Human guy) {
		guy.lay();
	}

	public static void main(String[] args) {
		PolymorphicTest p = new PolymorphicTest();
		Man man = new Man();
		p.method01(man);
	}
}

interface Human {
	void lay();
}

class Man implements Human {
	public void lay() {
		System.out.println("man lay...");
	}
}

class Woman implements Human {
	public void lay() {
		System.out.println("woman lay...");
	}
}