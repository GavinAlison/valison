package com.alison.base.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetTest {
	public static void main(String[] args) {
		HashSetTest t = new HashSetTest();
		t.method02();
	}

	public void method01() {
		// HashSet无序不可重复
		// 存储的元素类型重写了hashCode()方法与equals()
		// String类型重写了hashCode()与equals()方法
		HashSet set = new HashSet();
		set.add("java01");
		set.add("java01");
		set.add("java02");
		set.add("java03");
		set.add("java04");

		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void method02() {
		HashSet set = new HashSet();
		set.add(new Person("a1", 11));
		set.add(new Person("a2", 22));
		set.add(new Person("a3", 13));
		set.add(new Person("a2", 44));
		set.add(new Person("a1", 31));
		set.add(new Person("a7", 11));

		Iterator it = set.iterator();
		while (it.hasNext()) {
			Person p = (Person) it.next();
			System.out.println(p.toString());
		}
	}

	public void method03() {
		// 创建对象
		TreeSet ts = new TreeSet();
		// 添加元素
		ts.add("abcjjj");
		ts.add("abb");
		ts.add("daccc");
		ts.add("gfg");
		ts.add("geee");
		ts.add("r");

		// 进行迭代
		Iterator it = ts.iterator();

		// 循环取出元素
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void method05() {
		TreeSet ts = new TreeSet();

		ts.add(new Person("lisi02", 22));
		ts.add(new Person("lisi02", 21));
		ts.add(new Person("lisi007", 20));
		ts.add(new Person("lisi09", 19));
		ts.add(new Person("lisi06", 18));
		ts.add(new Person("lisi06", 18));
		ts.add(new Person("lisi007", 29));
		// ts.add(new Person("lisi007",20));
		// ts.add(new Person("lisi01",40));

		Iterator it = ts.iterator();
		while (it.hasNext()) {
			Person stu = (Person) it.next();
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}

	public void method04() {
		// 使用第二种排序方式，使得String类型的元素按照长度来排序。
		// 创建对象
		TreeSet ts = new TreeSet(new MyCompare());
		// 添加元素
		ts.add("abc");
		ts.add("bcc");
		ts.add("das");
		ts.add("bcde");
		ts.add("asdfg");
		ts.add("befqfca");

		// 进行迭代
		Iterator it = ts.iterator();

		// 循环取出元素
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// //定义一个类实现Comparator接口，并且覆盖compare（）方法。
	class MyCompare implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			// 进行强制类型转换
			String s1 = (String) o1;
			String s2 = (String) o2;

			// 进行比较
			if (s1.length() > s2.length())
				return 1;
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return 0;
		}
	}
	// 此种情况下，我们不方便修改源代码，而只需要修改比较方法时，我们就可以自己创建一个比较器。
	// 在建立TreeSet时，将比较器传入即可使元素按照特定比较方式输出
	
}
