package com.alison.spring.ioc.t3;

import java.util.List;
import java.util.Map;

public class CollectionClass {
	private List<String> list;
	private Map<Family, Person> map;
	private int[] arrInt;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<Family, Person> getMap() {
		return map;
	}

	public void setMap(Map<Family, Person> map) {
		this.map = map;
	}

	public int[] getArrInt() {
		return arrInt;
	}

	public void setArrInt(int[] arrInt) {
		this.arrInt = arrInt;
	}

}
