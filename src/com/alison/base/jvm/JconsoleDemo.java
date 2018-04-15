package com.alison.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个heap对象变化的例子<br>
 * 以便于jconsole查看eden中对象的变化<br>
 * VM: -Xms100m -Xmx100m
 * 
 * @author hy
 * 
 */
public class JconsoleDemo {

	static class OOMObject {
		public byte[] placeholder = new byte[64 * 1024];
	}

	public static void fillHeap(int num) throws Exception {
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0; i < num; i++) {
			// 稍作延时, 令监视曲线的变化更明显
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}

	public static void main(String[] args) throws Exception {
		fillHeap(1000);
	}
}
