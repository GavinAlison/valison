package com.alison.base.stringDemo;

import org.junit.Test;

public class StringDemo {
	@Test
	public void test() {
		String str = "hello string";
		str.length();
		System.out.println(str.charAt(0));
		System.out.println(str.codePointAt(0));
		System.out.println(str.length());
		System.out.println(str.codePointCount(0, str.length()));
		/**
char chatAt(int index)
codePointAt()
a.compareTo(b)
endsWith
startsWith
equals
equalsIgnoreCase
indexOf
lastIndexOf
length
String replace(oldString, newString)
toLowerCase
toUpperCase
substing(beginindex, endindex)
trim()
*/
		
		System.out.println("abcd".split(","));
		
		
	}
}
