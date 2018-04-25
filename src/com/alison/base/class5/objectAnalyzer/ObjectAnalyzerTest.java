package com.alison.base.class5.objectAnalyzer;

import java.util.ArrayList;

/**
 * this program users reflection to spy on objects <br>
 * 运用反射分析运行中的对象
 * 
 * @author hy 2017-12-15 1:58
 * 
 */
public class ObjectAnalyzerTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Integer> squares = new ArrayList();
		for (int i = 0; i <= 5; i++) {
			squares.add(i * i);
		}
		System.out.println(squares.toString());
		System.out.println(new ObjectAnalyzer().toString(squares));
	}
}
