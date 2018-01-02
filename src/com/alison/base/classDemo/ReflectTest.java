package com.alison.base.classDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

import javassist.Modifier;

public class ReflectTest {

	/**
	 * the program users reflection to print all features of a class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// read class name from command line args or user input
		Scanner in = new Scanner(System.in);
		System.out.println("Enter class name(e.g java.util.Date)");
		String name = in.next();
		try {
			Class clazz = Class.forName(name);
			Class superClazz = clazz.getSuperclass();
			String modifiers = Modifier.toString(clazz.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(" class " + name);
			if (superClazz != null && superClazz != Object.class)
				System.out.print("  extends " + superClazz.getName());
			System.out.print("{\n");
			printConstructors(clazz);
			System.out.println();
			printMethods(clazz);
			System.out.println();
			printFields(clazz);
			System.out.println("\n}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	/**
	 * prints all constructors of a class
	 * 
	 * @param clazz
	 */
	private static void printConstructors(Class clazz) {
		System.out.println("-------------custructors------------");
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor c : constructors) {
			String name = c.getName();
			System.out.print("	");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + "	");
			}
			System.out.print(name + "( ");
			// print parameter types
			Class[] types = c.getParameterTypes();
			for (int i = 0; i < types.length; i++) {
				if (i > 0) {
					System.out.print(", ");
				}
				System.out.print(types[i].getName());
			}
			System.out.println(" );");
		}
	}

	private static void printMethods(Class clazz) {
		System.out.println("----------method-------------");
		Method[] methods = clazz.getDeclaredMethods();
		for (Method me : methods) {
			String modifier = java.lang.reflect.Modifier.toString(me
					.getModifiers());
			System.out.print("	");
			if (modifier.length() > 0) {
				System.out.print(modifier + " ");
			}
			// print return type , method, parameter
			Class returnTypes = me.getReturnType();
			System.out.print(returnTypes.getName() + " " + me.getName() + "(");
			Class[] parameterTypes = me.getParameterTypes();
			for (int i = 0; i < parameterTypes.length; i++) {
				if (i > 0)
					System.out.print(", ");
				System.out.print(parameterTypes[i].getName());
			}
			System.out.println(");");

		}
	}

	private static void printFields(Class clazz) {
		// clazz.get
		System.out.println("---------fields-------------");
		Field[] fileds = clazz.getDeclaredFields();
		for (Field f : fileds) {
			String modifier = java.lang.reflect.Modifier.toString(f
					.getModifiers());
			System.out.print("	");
			if (modifier.length() > 0) {
				System.out.print(modifier + "	");
			}
			Class type = f.getType();
			System.out.print(type.getName() + "	" + f.getName());
			System.out.println(";");

		}
	}

}
