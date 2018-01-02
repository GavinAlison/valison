package com.alison.base.exceptionDemo;

import java.util.List;
import java.util.Map;

public class Item {
	
	private Map map;
	
	private int modCount;
	
	private List list;
	
	private Item() {
		// map.put("1", "one");
	}

	private static Item instance;

	public static Item getInstance() {
		if (instance == null) {
			instance = new Item();
		}
		return instance;
	}

	public void getItems() throws Exception {

	}

	public int size() {
		try {
			modCount = map.size();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NullPointerException("空指针异常!");
		}
		return modCount;
	}
	public Object length(){
		return  list.get(2);
	}
	
	
}
