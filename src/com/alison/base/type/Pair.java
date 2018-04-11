package com.alison.base.type;

/**
 * 泛型类
 * 
 * @author hy
 * 
 * @param <T>
 *            泛型类型
 */
public class Pair<T> {
	private T first;
	private T second;

	public Pair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}

	public Pair() {
		super();
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}

	// 泛型方法<T> 方法签名
	public <T> void method01(T... ts) {
		
	}

}
