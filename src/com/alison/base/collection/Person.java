package com.alison.base.collection;

public class Person implements Comparable {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		System.out.println(this.name + "....hashcode");
		return super.hashCode() & (age >>> 4);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person) obj;
		System.out.println(this.name + "...equals.." + p.name);
		return this.name.equals(p.name) && this.age == p.age;
	}

	@Override
	public int compareTo(Object obj) {
		if (!(obj instanceof Person))
			throw new RuntimeException("不是人对象");
		Person s = (Person) obj;
		if (this.age > s.age)
			return 1;
		if (this.age == s.age) {
			return this.name.compareTo(s.name);
		}
		return -1;
	}

}
