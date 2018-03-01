package com.alison.base.class12;

import java.util.GregorianCalendar;

public class PairTest2 {
	public static void main(String[] args) {
		GregorianCalendar[] birthdays = { new GregorianCalendar(1906, 12, 9), // G.Hopper
				new GregorianCalendar(1815, 12, 10), // A. Lovelace
				new GregorianCalendar(1903, 12, 3), // J. von Neumann
				new GregorianCalendar(1910, 6, 22), // K. Zuse
		};
		PairType<GregorianCalendar> mm = ArrayAlg1.minmax(birthdays);
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " + mm.getLast());
	}
}

class ArrayAlg1 {
	/**
	 * Gets the minimum and maximum of an array of objects of type T.
	 * 
	 * @param a
	 *            an array of objects of type T
	 * @return a pair with the min and max value, or null if a is null or empty
	 */
	public static <T extends Comparable> PairType<T> minmax(T[] a) {
		if (a == null || a.length == 0)
			return null;
		T min = a[0];
		T max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (min.compareTo(a[i]) > 0)
				min = a[i];
			if (max.compareTo(a[i]) < 0)
				max = a[i];
		}
		return new PairType<T>(min, max);
	}
}
