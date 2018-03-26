package com.alison.spring.jdbc;

import java.io.Serializable;

public class Student {
	private Serializable UidSerializable = 1L;
	private int id;
	private int version;
	private String name;
	private int age;
	private String ClassRoom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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

	public String getClassRoom() {
		return ClassRoom;
	}

	public void setClassRoom(String classRoom) {
		ClassRoom = classRoom;
	}

}
