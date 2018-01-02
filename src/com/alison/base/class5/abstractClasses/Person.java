package com.alison.base.class5.abstractClasses;

public abstract class Person {

	public abstract String getDescription();

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

}
