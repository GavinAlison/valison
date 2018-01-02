package com.alison.base.class6.interfaces;

public class Employee implements Comparable<Employee> {

	private String name;

	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	/**
	 * Compares employees by salary
	 * 
	 * @param other
	 *            another Employee object
	 * @return a negative value if this employy has a lower salary than
	 *         otherObject, 0 if the salaries are the same, a positive value
	 *         otherwise
	 */
	@Override
	public int compareTo(Employee other) {
		return Double.compare(salary, other.salary);
	}
}
