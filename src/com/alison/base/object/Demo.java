package com.alison.base.object;

public class Demo {
	public static void main(String[] args) {
		System.out.println(System.out);
		String[] arr = { "1", "2", "3", "4", "5" };
		System.out.println(java.util.Arrays.toString(arr));
		String[][] ars = { { "1", "1" }, { "2", "2" } };
		String[] a1 = new String[2];
		a1 = new String[] { "a", "s" };
		String[] a2 = new String[] { "a", "s" };
		String[] a3 = { "q", "w", "e" };
		// String[] a4 = new String[2]{"a","s"};//×
		System.out.println(java.util.Arrays.deepToString(ars));
		
	}
}
