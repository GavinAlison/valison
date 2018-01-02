package com.alison.json;

import java.util.Collection;

public class Student extends ListObject {
	private String name;
	private int age;
	private String sex;
	private String height;
	private Collection pageNum;
	private Collection temp1;

	// public void setPageBeanList(Collection pageBeanList) {
	// this.pageNum = pageBeanList;
	// }
	//	
	// public Collection getPageBeanList(){
	// return this.pageNum;
	// }

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
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

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student(String name, int age, Collection pageNum) {
		super();
		this.name = name;
		this.age = age;
		this.pageNum = pageNum;
	}

}
