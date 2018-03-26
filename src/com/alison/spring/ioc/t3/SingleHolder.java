package com.alison.spring.ioc.t3;

public class SingleHolder {
	private static class hodler {
		public static SingleHolder instance = new SingleHolder();
	}

	private SingleHolder() {
	}

	public static SingleHolder getInstance() {
		return hodler.instance;
	}

}
