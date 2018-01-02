package com.alison.base.class5.abstractClasses;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person {
	private double salary;
	private Date hireDay;

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
		super(name);
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		this.hireDay = calendar.getTime();
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary = salary + raise;
	}

	@Override
	public String getDescription() {
		return String.format("an employee with a salary of $%.2f", salary);
	}

}
