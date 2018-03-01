package com.alison.base.class12;

/**
 * 编写简单的泛型类，重在泛型变量，该成员变量的类型是泛型<br>
 * 含有一个或者多个泛型变量的类叫做泛型类
 * 
 * @author hy
 * 
 * @param <T>
 */
public class PairType<T> {
	private T first;
	private T last;

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getLast() {
		return last;
	}

	public void setLast(T last) {
		this.last = last;
	}

	public PairType(T first, T last) {
		super();
		this.first = first;
		this.last = last;
	}

	public PairType() {
		super();
	}

}
