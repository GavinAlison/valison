package com.alison.miance;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 使用队列来实现生产者与消费者模式<br>
 * 队列的底层数据结构为数组或者链表
 * 
 * @author hy
 * 
 */
public class MyQueue<T> {
	// 数组ArrayList
	ArrayList<T> arrayList;

	// push
	public synchronized T push(T e) {
		arrayList.add(e);
		return e;
	}

	// pop
	public synchronized T pop() {
		return arrayList.remove(arrayList.size() - 1);
	}

	// 或者使用双向列表
	LinkedList<T> linkedList;

	public synchronized T add(T e) {
		linkedList.add(e);
		return e;
	}

	public synchronized T remove(T e) {
		return linkedList.pop();
	}

}