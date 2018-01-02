package com.alison.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class URLDemo {
	String urlStr = "http://www.baidu.com/index.html?query=123#j2ee";

	// 使用java.net的URL类获取URL的各个部分参数：
	@Test
	public void test01() {
		try {
			URL url = new URL(urlStr);
			System.out.println("URL: " + url.toString());
			System.out.println("协议protocol: " + url.getProtocol());
			System.out.println("验证信息authority: " + url.getAuthority());
			System.out.println("主机名host: " + url.getHost());
			System.out.println("端口port: " + url.getPort());
			System.out.println("默认端口defport: " + url.getDefaultPort());
			System.out.println("请求参数query: " + url.getQuery());
			System.out.println("文件名以及请求参数file and query: " + url.getFile());
			System.out.println("定位位置: " + url.getRef());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	// 以下实例中URL采用了HTTP 协议。 openConnection 返回HttpURLConnection对象。
	@Test
	public void test02() {
		try {
			URL url = new URL(urlStr);
			URLConnection urlconnection = url.openConnection();
			HttpURLConnection connection = null;
			if (urlconnection instanceof HttpURLConnection) {
				connection = (HttpURLConnection) urlconnection;
			} else {
				System.out.println("请输入URL地址");
				return;
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "gb2312"));
//			ISO-8859-1
			String urlString = "";
			String current;
			while ((current = in.readLine()) != null) {
				urlString += current;
				System.out.println(urlString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
