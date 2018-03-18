package com.alison.base.jvm;

public class OutOfMemeryErrorTest {
	private void dontstop() {
		while (true) {
		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontstop();
				}
			});
		}
	}

	public static void main(String[] args) {
		OutOfMemeryErrorTest oom = new OutOfMemeryErrorTest();
		oom.stackLeakByThread();
	}
}
