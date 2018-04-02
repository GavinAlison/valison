package com.alison.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.alison.webservice.service.impl.MyWebServiceImpl;

public class ClientTest {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/valison/MyService?wsdl");
		QName qname = new QName(
				"http://impl.server.webservice.remote.ssm.com/",
				"MyWebServiceImpl");
		Service service = Service.create(url, qname);
		MyWebServiceImpl serviceimpl = service.getPort(MyWebServiceImpl.class);
		System.out.println(serviceimpl.method01());
	}
}
