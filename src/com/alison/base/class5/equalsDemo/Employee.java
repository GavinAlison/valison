package com.alison.base.class5.equalsDemo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private double salary;
	private String name;
	private Date hireDay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String name, double salary, int year, int month, int day) {
		super();
		this.salary = salary;
		this.name = name;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		this.hireDay = calendar.getTime();
	}

	public Employee() {
		super();
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary = salary + raise;
	}

	public Employee getEl() {
		return new Employee();
	}

	public void getIp(final Employee em) {
		System.out.println(em);
	}

	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass()) {
			return false;
		}
		Employee other = (Employee) otherObject;
		// base on 1.7
		// return java.util.Objects.equals(name, other.name)
		// && salary == other.salary
		// && java.util.Objects.equals(hireDay, other.hireDay);

		return Util.equals(name, other.name) && salary == other.salary
				&& Util.equals(hireDay, other.hireDay);

	}

	public int hashCode() {
		return name.hashCode() + (int) salary + hireDay.hashCode();
	}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary
				+ ",hireday=" + hireDay + "]";
	}

}
