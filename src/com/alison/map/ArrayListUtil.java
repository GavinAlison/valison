package com.alison.map;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListUtil {
	@Test
	public void test01() {
		List<Integer> list = new ArrayList<Integer>();
		list.size();
		// indexOutOfBoundsException
		// list.get(0);
		// listget(0) 等效于 elementData[0]
		// indexoutOfBoundsException：index:2, size:1
		// list.add(2, "asd");
		// list.add(1,"asd")等效于elementData[2]="asd";
		int i = 0;
		while (i < 10) {
			list.add(i);
		}
		Object obj[] = new Object[list.size()];
		list.toArray(obj);
	}

	public void test02() {

	}
}
