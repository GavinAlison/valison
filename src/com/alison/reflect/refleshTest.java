package com.alison.reflect;

import java.util.HashMap;
import java.util.Map;


public class refleshTest {
	public static void main(String[] args) {
		MessageBox msg = new MessageBox();
		try {
			Map<Object, Object> map = (HashMap<Object, Object>) ClassReflechUtil.getFields(msg);
			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				System.out.println("key: " + entry.getKey() + " , value:"
						+ entry.getValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
