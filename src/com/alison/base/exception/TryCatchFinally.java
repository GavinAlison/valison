package com.alison.base.exception;

public class TryCatchFinally {
	public static int func(int i) {
		System.out.println("func");
		try {
			System.out.println("try block");
			if (i == 1)
				return 1;
			if (i == 2)
				return 2;
			if (i == 3)
				return 3;
			return -1;
		} catch (Exception e) {
			System.out.println("catch block");
			return -2;
		} finally {
			System.out.println("finally block");
			 return -3;
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {
			System.out.println(func(i));
			System.out.println("--------------");
		}
	}
	/**
	 * 
func
try block
finally block
-3
--------------
func
try block
finally block
-3
--------------
func
try block
finally block
-3
--------------
func
try block
finally block
-3
--------------
	 */
}
