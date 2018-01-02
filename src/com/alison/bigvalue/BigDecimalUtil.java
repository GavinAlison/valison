package com.alison.bigvalue;

import java.math.BigDecimal;

public class BigDecimalUtil {
	public BigDecimal add(BigDecimal val1, BigDecimal val2) {
		return val1.add(val2);
	}

	public BigDecimal subtract(BigDecimal val1, BigDecimal val2) {
		return val1.subtract(val2);
	}

	public BigDecimal multiply(BigDecimal val1, BigDecimal val2) {
		return val1.multiply(val2);
	}

	public BigDecimal divide(BigDecimal val1, BigDecimal val2) {
		return val1.divide(val2);
	}

	private void method1() {
		// 转换成BigDecimal大数值
		BigDecimal b = BigDecimal.valueOf(123);
		BigDecimal c = BigDecimal.valueOf(6);
		System.out.println(b);
		System.out.println(b.compareTo(c));
	}
	
	public static void main(String[] args) {
		BigDecimalUtil b = new BigDecimalUtil();
		b.method1();
	}
}
