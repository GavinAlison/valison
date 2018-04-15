package com.alison.base.class5.abstractClasses;

/**
 * 抽象类<br>
 * 修饰符： abstract <br>
 * 子类修饰符： extends,单继承 <br>
 * 变量： 实例变量和常量 <br>
 * 方法： 实例方法和抽象方法(可有可无)<br>
 * 构造器： 可以有，但是不能创建抽象类对象(不能实例化)， 只能声明变量，在引用一个非抽象子类的对象.
 * 
 * @author hy
 * 
 */
public abstract class AbstractDemo {
	private static AbstractDemo d = null;

	public AbstractDemo() {

	}

	public static void main(String[] args) {
		d = new AbstractDemo() {
		};
		d = new B();
	}

}

class B extends AbstractDemo {
	public B() {
	}
}
