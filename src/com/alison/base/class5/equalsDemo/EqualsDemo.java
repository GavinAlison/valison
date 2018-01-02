package com.alison.base.class5.equalsDemo;

/**
 * This program demonstrates the equals method.
 * 
 * @version 1.0 2017-12-23
 * @author hy
 * 
 */
public class EqualsDemo {
	public static void main(String[] args) {
		Employee em1 = new Employee("alice", 7500, 2017, 4, 30);
		Employee em2 = em1;
		Employee em3 = new Employee("alice", 7500, 2017, 4, 30);
		Employee em4 = new Employee("alice", 7500, 2017, 4, 22);

		System.out.println("em1 == em2:" + (em1 == em2));
		System.out.println("em1 == em3:" + (em1 == em3));
		System.out.println("em3 == em4:" + (em3 == em4));
		System.out.println("em1.equals(em3):" + em1.equals(em3));
		System.out.println("em1.hashCode():" + em1.hashCode());
		Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
		Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

		System.out.println("alice1 == alice2: " + (alice1 == alice2));

		System.out.println("alice1 == alice3: " + (alice1 == alice3));

		System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

		System.out.println("alice1.equals(bob): " + alice1.equals(bob));

		System.out.println("bob.toString(): " + bob);

		Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		System.out.println("boss.toString(): " + boss);
		System.out.println("carl.equals(boss): " + carl.equals(boss));
		System.out.println("alice1.hashCode(): " + alice1.hashCode());
		System.out.println("alice3.hashCode(): " + alice3.hashCode());
		System.out.println("bob.hashCode(): " + bob.hashCode());
		System.out.println("carl.hashCode(): " + carl.hashCode());
	}
}
