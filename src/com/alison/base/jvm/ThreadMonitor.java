package com.alison.base.jvm;

import java.util.Map;
import java.util.Set;

/**
 * 线程监视器
 * 
 * @author hy 2018-04-14 22:05
 * 
 */
public class ThreadMonitor {
	public static void main(String[] args) {
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Map.Entry<Thread, StackTraceElement[]>> set = map.entrySet();
		for (Map.Entry<Thread, StackTraceElement[]> entry : set) {
			System.out.println("检测到线程[" + entry.getKey().getName()
					+ "],线程详细信息：");
			for (StackTraceElement el : entry.getValue()) {
				System.out.println(el);
			}
		}

	}
}
