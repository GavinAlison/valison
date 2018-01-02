package com.alison.base.stringDemo;

import org.junit.Test;

import com.alison.json.Student;

public class Demo implements Cloneable {
	public Demo() {
	}

	public static void main(String[] args) throws Exception {
		Demo d = new Demo();
		String str = "2222";
		Student stu = new Student();
		stu.setAge(11);
		d.changeStr(str);
		System.out.println(str);// 拷贝一份，没有改变原来的值
		d.chagerObj(stu);
		System.out.println(stu.getAge());// 拷贝了一份，但是拷贝的变量还是指向这个引用，
		// 引用的对象属性改变了，对应变量取引用对象的值就会改变
		// System.out.println(d.clone() == d);
		// System.out.println(d.clone().getClass() == d.getClass());
		// System.out.println(d.clone().equals(d));
	}

	@Test
	public void testname() throws Exception {
		String str = "as";
		Object obj = (Object) str;
		String strs = (String) obj;
	}

	public void changeStr(String str) {
		str = "123";
	}

	public void chagerObj(Student s) {
		s.setAge(100);
	}
}
