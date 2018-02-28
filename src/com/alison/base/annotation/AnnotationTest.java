package com.alison.base.annotation;

import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) {
		try {
			// 使用类加载器加载类
			Class clazz = Class.forName("com.alison.base.annotation.HR");
			// 找到类上面的注解
			boolean isExist = clazz.isAnnotationPresent(Description.class);
			if (isExist) {
				// 获取类上所有的注解
				// Annotation[] annoArr = clazz.getAnnotations()
				// 拿到注解实例，解析类上面的注解
				Description d = (Description) clazz
						.getAnnotation(Description.class);
				System.out.println(d.desc());

				Method[] methodArr = clazz.getMethods();
				for (Method m : methodArr) {
					isExist = m.isAnnotationPresent(Description.class);
					if (isExist) {
						Description methodDescription = m
								.getAnnotation(Description.class);
						System.out.println(methodDescription.desc());
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
