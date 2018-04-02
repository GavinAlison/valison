package com.alison.webservice.push;

import javax.xml.ws.Endpoint;

import com.alison.webservice.service.impl.MyWebServiceImpl;

public class ServicePush {
	public static void main(String[] args) {
		// 参数1：服务被访问的url ip+端口号+服务名
		// 参数2：实现类
		Endpoint.publish("http://localhost:8080/valison/MyService",
				new MyWebServiceImpl());
		System.out.println("Web Service服务发布成功");
		// System.exit(0);
		// 查看WebService服务是否启动 url+？wsdl
		// http://localhost:8080/valison/MyService?wsdl是否能显示
	}
}
