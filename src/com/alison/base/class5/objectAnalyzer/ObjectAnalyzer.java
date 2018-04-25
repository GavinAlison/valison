package com.alison.base.class5.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 
 * @author hy 2017-12-15 1:58
 * 
 */

@SuppressWarnings("unchecked")
public class ObjectAnalyzer {

	private ArrayList<Object> visited = new ArrayList();

	/**
	 * converts an object to a string representation that lists all fields.
	 * 
	 * @param obj
	 *            an object
	 * @return a string with the object's class name and all fields names and
	 *         values
	 */
	public String toString(Object obj) {
		if (obj == null)
			return "null";
		if (visited.contains(obj))
			return "...";
		visited.add(obj);
		Class cl = obj.getClass();
		if (cl == String.class) {
			return (String) obj;
		}
		if (cl.isArray()) {
			StringBuffer r = new StringBuffer("" + cl.getComponentType());
			r.append("[]{");
			for (int i = 0; i < Array.getLength(obj); i++) {
				if (i > 0) {
					r.append(",\n");
				}
				Object val = Array.get(obj, i);
				if (cl.getComponentType().isPrimitive()) {
					r.append(val);
				} else {
					r.append(toString(val));
				}
			}
			r.append("}");
			return r.toString();
		}

		String r = cl.getName();
		// inspect the fields of this class and all superclass
		do {
			r += "[";
			Field[] fields = cl.getDeclaredFields();
			AccessibleObject.setAccessible(fields, true);
			// get the names and values of all fields
			for (Field f : fields) {
				if (!Modifier.isStatic(f.getModifiers())) {
					if (!r.endsWith("["))
						r += ",\n";
					r += f.getName() + "=";
					try {
						Class t = f.getType();
						Object val = f.get(obj);
						if (t.isPrimitive()) {
							r += val;
						} else {
							r += toString(val);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			r += "]";
			cl = cl.getSuperclass();
		} while (cl != null);
		return r;
	}
}
