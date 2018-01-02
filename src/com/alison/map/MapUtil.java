package com.alison.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtil {
	// 遍历map
	public void outMap(Map<Object, Object> map) {
		for (Map.Entry<Object, Object> entry : map.entrySet()) {
			System.out.println("key:" + entry.getKey() + ",value:"
					+ entry.getValue());
		}
	}

	public void outMap2(Map map) {
		for (Object key : map.keySet()) {
			System.out.println("key: " + key);
		}
		for (Object value : map.values()) {
			System.out.println("value: " + value);
		}
	}

	public void outMap3(Map map) {
		Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Object, Object> entry = it.next();
			System.out.println("key: " + entry.getKey() + ", value: "
					+ entry.getValue());
		}
	}

	// 通过键找值遍历（效率低）
	public void outMap4(Map map) {
		for (Object key : map.keySet()) {
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
	}
}
