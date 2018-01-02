package com.alison.base.class5.methods;

import java.lang.reflect.Method;

/**
 * This program shows how to invoke methods through reflection
 * 
 * @author hy 2017-12-17 16:17 <br>
 *         Class, Constructor, Field, Method<br>
 *         --------------------<br>
 *         **获取Method对象的方法：<br/>
 *         --------------------<br>
 *         Class类中的方法，如getMethod(), getDeclareMethods()<br>
 *         1. Method getMethod(String name, Class... parameterTypes)<br>
 *         通过getMethod方法，该方法是根据方法的字符串和参数类型得到的 <br>
 *         2. Method getDeclaredMethods()<br>
 *         通过getDeclaredMethods返回Method对象数组，对数组进行查找，找到需要的方法为止<br>
 *         ------------------- <br>
 *         **调用Method的方法<br>
 *         -------------------<br>
 *         Method类的方法,如invoke()<br>
 *         Object invoke(Object obj, Object... args)<br>
 *         如果需要返回的类型是基本类型，invoke方法会返回其包装器类型<br>
 *         如果该方法是静态的，第一个参数为null; 如果第二个显示参数需要的参数的数量为0，则数组的长度可以是0或者参数为null.<br>
 *         If the underlying method is static, the class that declared the
 *         method is initialized if it has not already been initialized;<br>
 *         If the method completes normally, the value it returns is returned to
 *         the caller of invoke; if the value has a primitive type, it is first
 *         appropriately wrapped in an object. However, if the value has the
 *         type of an array of a primitive type, the elements of the array are
 *         <i>not</i> wrapped in objects; in other words, an array of primitive
 *         type is returned. If the underlying method return type is void, the
 *         invocation returns null<br>
 *         ------------------------<br>
 *         1. invoke的参数可能有一个, 报错， wrong number of arguments。<br>
 * 
 * 
 * 
 */
public class MethodTableTest {

	public static void main(String[] args) throws Exception {
		// get method pointers to the square and sqrt methods
		Method square = MethodTableTest.class.getMethod("square", double.class);
		Method sqrt = Math.class.getMethod("sqrt", double.class);

		// print tables of x- and y-values
		printTable(1, 10, 10, square);
		printTable(1, 10, 10, sqrt);
		// Math.class.getDeclaredMethods();
		// System.out.println(square.invoke(null, 10d));

	}

	/**
	 * returns the square of a number
	 * 
	 * @param x
	 *            a number
	 * @return x squared
	 */
	public static double square(double x) {
		return x * x;
	}

	public static void printTable(double from, double to, int n, Method f) {
		// print out the method as table header
		System.out.println(f);

		double dx = (to - from) / (n - 1);
		for (double x = from; x <= to; x += dx) {
			try {
				double y = (Double) f.invoke(null, x);
				System.out.printf("%10.4f | %10.4f%n", x, y);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
