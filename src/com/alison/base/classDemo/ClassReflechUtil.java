package com.alison.base.classDemo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ClassReflechUtil {
	/**
	 * Constructor 构造函数 <br>
	 * Class 类<br>
	 * Field 字段， 成员属性<br>
	 * Method 成员方法<br>
	 * Modifer 类中个元素的修饰符 <br>
	 * Array 对数组进行操作
	 * 
	 * class.forName("className") <br>
	 * obj.getClass()<br>
	 * Class.class
	 * 
	 * class.newInstance();
	 * 
	 */
	private static Map<String, Object> propertyMap = new HashMap<String, Object>();

	public static Map getFields(Object obj) throws Exception {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			propertyMap.put(f.getName(), f.get(obj));
		}
		return propertyMap;
	}

}
