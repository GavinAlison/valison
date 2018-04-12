package com.alison.base.threadpool;

import java.util.Stack;

/**
 * 题目： 利用数据结构和多线程写一个生产者与消费者模式<br>
 * 思路： 1.数据结构一般是集合中的，其中选择Stack栈,LIFO(last-in-first-out)<br>
 * 2. 这个stack变量需要成为共享的，共享的方式有两种，一种是设置成静态的，一种是作为在线程类的构造函数的参数，
 * 先定义一个stack对象，然后将这个对象分别传递给线程的构造函数<br>
 * 3. 现在定义了一个类，里面管理者stack对象，使用构造函数的参数方法共享变量，<br>
 * 这里还需要定义存值add与取值的方法pop，一遍线程调用它
 * 
 * @author hy
 * 
 */
public class Product {

	private int i = 0;

	public Stack<Integer> stack = new Stack<Integer>();

	public synchronized int add() {
		return stack.push(i++);
	}

	public synchronized int pop() {
		return stack.pop();
	}
}
