package com.alison.base.stringDemo;

public class StringBuilderDemo {
	
	
	/**
	 * Stirngbuilder    线程不安全 
	 * StringBuffer     线程安全
	 * 
	 * ==================
	 * Stirngbuilder
	 * --------
	 * new StringBuilder();
	 * append(str / c)  insert(offset, c/str)    
	 * setCharAt(int i, char c)
	 * delete(start, end)
	 * toString()
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("asd");
		StringBuilder sb = sbuilder.insert(1, "qwe");
		System.out.println(sb+"---"+ sbuilder);
	}
}
