package com.alison.base.extendsDemo;

public class Demo {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.method03();
	}

	public void method01() {
		Employee e = new Employee();
		Manager m = new Manager();
		m.setBouns(10);
		System.out.println(m.getBouns());
		System.out.println("---------------------------");
		// 子类数组类型转换成超类数组类型,此时超类和子类的数组都引用同一个数组
		Manager[] ma = new Manager[6];
		Employee[] staff = ma;
		staff[0] = new Employee("jack", 10000, 1990, 10, 22);
		ma[0].setBouns(900);
		// java.lang.ArrayStoreException
	}
	
	private void method02() {
		Manager m = new Manager();
		System.out.println(m.getEl());
	}
	
	private void method03() {
		Employee em = new Employee();
		Manager m = new Manager();
		em.getIp(em);
		m.getIp(m);
		m.getIp(em);
	}

}
