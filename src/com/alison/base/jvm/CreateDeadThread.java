package com.alison.base.jvm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 线程死循环演示<br>
 * 使用jconsole演示thread的状态与内存情况<br>
 * VM： -Xms100m -Xmx100m
 * 
 * @author hy
 * 
 */
public class CreateDeadThread {
	// 创建死循环方法
	public static void createBusyThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					;
				}
			}
		}, "testbusythread");
		thread.start();
	}

	// 创建线程锁等待
	public static void createLockDeadThread(final Object lock) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
						// 本线程进入wait状态之后，需要其他线程进行notify()
						// 或者notifyAll()唤醒，才可以进行下去
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "lockDeadThread");
		thread.start();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		createBusyThread();
		br.readLine();
		Object obj = new Object();
		createLockDeadThread(obj);
	}
}
