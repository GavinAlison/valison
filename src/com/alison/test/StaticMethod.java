package com.alison.test;

public class StaticMethod {
	
	public void method01() {
		int i =11;
		//i: 1-12
		System.out.print((i+1)>12?(i+1)-12:(i+1));
		System.out.print(",");
		System.out.print((i+2)>12?(i+2)-12:(i+2));
	}

	public static void main(String[] args) {
		StaticMethod me = new StaticMethod();
		me.method02();
	}
	/**
	 * || 短路或
	 * true || <expression>  有真则后面的表达式不用运算
	 * false || <expression>  第一个表达式为false时，后面的表达式需要运算
	 * <br>
	 * && 短路与
	 * true && <expression> 有真，后面表达式需要运算
	 * false && <expression> 有假，则后面表达式不需要运算
	 * 
	 */
	public void method02(){
		boolean flag = false;
		int i =2;
		flag = 1==1 || i++>1;
		System.out.println(flag+"-"+i);
	}
	
}
