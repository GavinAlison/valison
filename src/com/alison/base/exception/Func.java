package com.alison.base.exception;

public class Func {

	@SuppressWarnings("finally")
	public int foo() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

	public static void main(String[] args) {
		Func f = new Func();
		System.out.println(f.foo());
	}
}
