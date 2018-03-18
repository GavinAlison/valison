package com.alison.base.jvm;

/**
 * 测试发生statckOutFlowError错误<br>
 * 当java虚拟机栈的深度不允许动态扩展时，当前线程申请栈深度超过当前java虚拟机栈的最大深度时，会抛出statckOutFlowError异常
 * 
 * @author hy
 * 
 */
public class JavaVMStackOutFlowError {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackOutFlowError oom = new JavaVMStackOutFlowError();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: " + oom.stackLength);
			throw e;
		}
	}
}
