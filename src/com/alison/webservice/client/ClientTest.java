package com.alison.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

import com.alison.webservice.out.service.impl.MyWebService;
import com.alison.webservice.out.service.impl.MyWebServiceImplService;
import com.alison.webservice.service.impl.MyWebServiceImpl;

// 用jax-ws开发的客户端会自动适应服务端的版本。
public class ClientTest {
	// TODO 待处理，出错了
	public static void main(String[] args) throws MalformedURLException {
		// URL url = new URL("http://localhost:8080/valison/MyService?wsdl");
		// // Qname是注册到服务中的
		// QName qname = new QName("http://impl.service.webservice.alison.com/",
		// "MyWebServiceImplService");
		// Service service = Service.create(url, qname);
		// MyWebServiceImpl serviceimpl = service.getPort(MyWebServiceImpl.class);
		// System.out.println(serviceimpl.method01());
	}

	@Test
	public void method01() {
		// 调用webservice
		MyWebService a = new MyWebServiceImplService()
				.getMyWebServiceImplPort();
		String str = a.method01("1111");
		System.out.println(str);
	}
}
