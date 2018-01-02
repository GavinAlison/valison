package com.alison.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	public static void main(String[] args) {
		RegexDemo re = new RegexDemo();
		re.method04();
	}

	public void method01(String input) {
		// Pattern.compile(regex, flags);
		// Pattern.compile(regex);
		// Matcher matcher = Pattern.compile("/^\\d{3,}$/").matcher(input)
		Pattern pattern = Pattern.compile("/^\\d{3,}$/");
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("ok!");
		}

		// Pattern.matches(regex, input)
		Boolean flag = Pattern.matches("/^\\d+$/", input);
		if (flag) {
			System.out.println("ok!");
		}
	}

	public void method02() {
		String strExpression = "Evening is full of the linet's wings.";
		Matcher m = Pattern.compile("\\w+").matcher(strExpression);
		int i = 0;
		// Matcher.find( )的功能是发现CharSequence里的，与pattern相匹配的多个字符序列
		while (m.find(i++)) {
			System.out.println(m.group() + "-" + m.start() + "-" + m.end());
		}
	}

	@SuppressWarnings("unused")
	private void method03() {
		String str = "javas has regex/nJava has regex/n JAVA has pretty  good regular expression/n";
		Matcher m = Pattern.compile("java",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE).matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}

	private void method04() {
		Matcher m = Pattern.compile("[frb][aiu][gx]").matcher(
				"fix the rug with bags");
		while (m.find())
			System.out.println(m.group());
		System.out.println("------");
		// reset str
		m.reset("fix the rig with rags");
		while (m.find())
			System.out.println(m.group());
	}
}
