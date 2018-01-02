package com.alison.base.class5.inheritance;

public class Manager extends Employee {

	private double bouns;

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		// this.getSalary();
		// super.getSalary();
		// 这些都不会报错
		this.bouns = bouns;
	}

	public double getSalary() {
		return super.getSalary() + bouns;
	}

	/**
	 * 
	 * @param name
	 * @param salary
	 * @param year
	 * @param month
	 * @param day
	 */
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bouns = 0d;
	}

	public Manager() {
		super();
	}

	@Override
	public Manager getEl() {
		return new Manager();
	}

	public void getIp(final Employee em) {
		System.out.println(em);
	}
}
