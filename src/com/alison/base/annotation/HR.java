package com.alison.base.annotation;

@Description(desc = "this is a HR")
public class HR extends Employee {

	@Override
	@Description(desc = "this is am method annotation")
	public String name() {
		return "1";
	}

	@Override
	public int age() {
		return 1;
	}

	@Override
	public void work() {
	}
}
