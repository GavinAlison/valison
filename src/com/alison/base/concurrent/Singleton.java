package com.alison.base.concurrent;

public class Singleton {
	private Singleton() {
	}

	private static class SingleHolder {
		public static final Singleton instance = new Singleton();
	}

	public static Singleton getInstance() {
		return SingleHolder.instance;
	}

}
