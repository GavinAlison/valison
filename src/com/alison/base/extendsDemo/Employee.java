package com.alison.base.extendsDemo;

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
}
