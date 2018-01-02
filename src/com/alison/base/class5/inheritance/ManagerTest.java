package com.alison.base.class5.inheritance;

/**
 * this program demonstrates inheritance.
 * 
 * @version 1.0 2017-12-22
 * @author hy
 * 
 */
public class ManagerTest {

	public static void main(String[] args) {
		// construct a manager object
		Manager boss = new Manager("carl craker", 80000, 1987, 12, 15);
		boss.setBouns(5000);

		Employee[] staff = new Employee[3];

		// fill the staff array with manager and employee objects.
		staff[0] = boss;
		staff[1] = new Employee("harry hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("tommy tester", 40000, 1990, 3, 15);

		// print pout information about all employee objects.
		for (Employee e : staff) {
			System.out.println("name=" + e.getName() + ", salary="
					+ e.getSalary());
		}
	}
}
