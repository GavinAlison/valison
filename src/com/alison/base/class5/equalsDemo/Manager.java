package com.alison.base.class5.equalsDemo;

public class Manager extends Employee {

	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		// this.getSalary();
		// super.getSalary();
		// 这些都不会报错
		this.bonus = bonus;
	}

	public double getSalary() {
		return super.getSalary() + bonus;
	}

	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0d;
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

	@Override
	public boolean equals(Object otherObject) {
		return super.equals(otherObject)
				|| (((Manager) otherObject).bonus == bonus);

	}

	@Override
	public int hashCode() {
		return super.hashCode() + 17 * new Double(bonus).hashCode();
	}

	@Override
	public String toString() {
		return super.toString() + "[bonus=]" + bonus;
	}
	
}
