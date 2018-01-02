package com.alison.bigvalue;

import java.math.BigInteger;

/**
 * 提供大数值的基本运算
 * 
 * @author alison
 * 
 */
public class BigIntegerUtil {
	/**
	 * 大数值有BigInteger和BigDecimal类型
	 */
	public BigInteger add(BigInteger val1, BigInteger val2) {
		return val1.add(val2);
	}

	public BigInteger subtract(BigInteger val1, BigInteger val2) {
		return val1.subtract(val2);
	}

	public BigInteger multiply(BigInteger val1, BigInteger val2) {
		return val1.multiply(val2);
	}

	public BigInteger divide(BigInteger val1, BigInteger val2) {
		return val1.divide(val2);
	}

	public BigInteger mod(BigInteger val1, BigInteger val2) {
		return val1.mod(val2);
	}

	private void method1() {
		// 转换成BigInteger大数值
		BigInteger b = BigInteger.valueOf(123);
		BigInteger c = BigInteger.valueOf(6);
		BigInteger b1 = b.mod(c);
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b.compareTo(c));
	}
	
	public static void main(String[] args) {
		BigIntegerUtil b = new BigIntegerUtil();
		b.method1();
	}

}
