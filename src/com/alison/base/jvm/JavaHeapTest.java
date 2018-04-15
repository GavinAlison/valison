package com.alison.base.jvm;

public class JavaHeapTest {
	private String oom;
	StringBuffer sb = new StringBuffer();

	public JavaHeapTest() {
		int i = 0;
		while (true) {
			i++;
			try {
				sb.append("a");
			} catch (OutOfMemoryError e) {
				e.printStackTrace();
				break;
			}
		}
		this.oom = sb.toString();
	}

	public String getOom() {
		return oom;
	}

	public void setOom(String oom) {
		this.oom = oom;
	}

	public StringBuffer getSb() {
		return sb;
	}

	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}

	public static void main(String[] args) {
		JavaHeapTest javaHeapTest = new JavaHeapTest();
		System.out.println(javaHeapTest.getOom().length());
	}

}
