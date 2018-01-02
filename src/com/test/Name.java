package com.test;

public class Name {
	// 姓名的个数
	private int count;
	// 姓名的长度
	private int nameLength;
	// 男女
	private String sex;
	// 名字值
	private String nameValue;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNameLength() {
		return nameLength;
	}

	public void setNameLength(int nameLength) {
		this.nameLength = nameLength;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}

	public Name(int count, int nameLength, String sex, String nameValue) {
		super();
		this.count = count;
		this.nameLength = nameLength;
		this.sex = sex;
		this.nameValue = nameValue;
	}

	public Name(int count, int nameLength, String sex) {
		super();
		this.count = count;
		this.nameLength = nameLength;
		this.sex = sex;
	}

	public Name(int count, int nameLength) {
		super();
		this.count = count;
		this.nameLength = nameLength;
	}

	public Name(String sex, String nameValue) {
		super();
		this.sex = sex;
		this.nameValue = nameValue;
	}

	public Name() {
		super();
	}

}
