package com.alison.base.exceptionDemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.alison.json.MessageBox;
import com.common.util.ServletUtils;

public class Exception1 {

	private Item item;

	@Test
	public void method1() throws Exception {
		FileInputStream input = new FileInputStream(new File("d:/aaa"));
	}

	@Test
	public void method2() throws Exception {
		Item.getInstance().getItems();
	}

	@Test
	public void method3(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			Item.getInstance().size();
		} catch (Exception e) {
			e.printStackTrace();
			MessageBox msg = new MessageBox(1, "error", "参数" + e.getMessage(),
					"");
			ServletUtils.print(response, msg.toJson());
		}
	}

	@Test
	public void method4() {
		
		Item.getInstance().length();
	}

	@Test
	public void method5() throws Exception {
		Exception1 e1 = null;
		new ArrayList().get(8);
		e1.method1();
		String item = "Item";
		Class clazz = Class.forName(item);
		clazz.newInstance();
		//获取反射运行时类
		Class clazztemp = Class.forName(item);
		e1.getClass();
		Class clazzItem = Item.class;
	}
	
	
	@Test
	public void readData() throws Exception {
		File file = new File("d:\\qqq\\1.txt");
	}
	
	public void method6(){
		Item.getInstance().size();
	}
}
