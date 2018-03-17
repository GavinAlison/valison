package com.alison.base.concurrent.t9;

public class MultiThreadObject {
	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 10;
		};
	};

	public static Integer getInteger() {
		return local.get();
	}

	public static void setInteger(Integer value) {
		local.set(value);
	}

	public static Integer getNextInteger() {
		local.set(local.get() + 1);
		return local.get();
	}
}
