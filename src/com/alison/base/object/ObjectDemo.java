package com.alison.base.object;

import java.lang.String;

public class ObjectDemo {
	public static void main(String[] args) {
		String str = "OK";
		StringBuilder sb = new StringBuilder(str);
		String t = new String("OK");
		String t1 = new String(str);
		StringBuilder sbt = new StringBuilder(t);
		System.out.println("str.hashCode()-" + str.hashCode());
		System.out.println("sb.hashCode()-" + sb.hashCode());
		System.out.println("t.hashCode()-" + t.hashCode());
		System.out.println("sbt.hashCode()-" + sbt.hashCode());
	}
}
