package com.alison.base.class6.interfaces;

import java.util.Arrays;

/**
 * this program demonstrates the use of the compareable interface
 * 
 * @version 1.0 2017-12-28
 * @author hy
 * 
 */
public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 35000);
		staff[2] = new Employee("Tony Tester", 35000);
		Arrays.sort(staff);

		// print out information about all Employee objects
		for (Employee e : staff) {
			System.out.println("name=" + e.getName() + ", salary="
					+ e.getSalary());
		}

	}
}
