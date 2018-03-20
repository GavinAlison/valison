package com.alison.base.exception;

public class AlwaysFinally {
	public static void main(String[] args) {
		System.out.println("entering first try block");
		try {
			System.out.println("entering second try block");
			try {
				throw new FourException();
			} finally {
				System.out.println("finally in 2nd try block");
			}
		} catch (Exception e) {
			System.out.println("caught FourException in 1st try block");
		} finally {
			System.out.println("finally in 1st try block");
		}
	}
	/**
	 * 结果：<br>
	 * entering first try block! <br>
	 * entering second try block <br>
	 * finally in 2nd try block <br>
	 * caught FourException in 1st try block <br>
	 * finally in 1st try block
	 */
}

class FourException extends Exception {
}
