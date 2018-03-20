package com.alison.base.class1;

public class StaticDemo {
	private static final String constantValue = "000";
	private static final String value;
	private static String name;
	
	String description;
	static {
		// description = "123";// error, Cannot make a static reference to the
		// non-static field description
		name = "nana";
		// constantValue = "qwe";// The final field StaticDemo.constantValue
		// cannot be assigned
		age = 12;
		value = constantValue;
	}
	private static int age;
	private static final String constantValue2 = "000";
	private static final String value2 = "111";
	private static String name2;

}
