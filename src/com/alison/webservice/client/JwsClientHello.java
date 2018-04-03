package com.alison.webservice.client;

import com.alison.webservice.out.Jws.JwsServiceHello;
import com.alison.webservice.out.Jws.JwsServiceHelloService;

public class JwsClientHello {
	public static void main(String[] args) {
		// 调用成功
		// 调用webservice
		JwsServiceHello hello = new JwsServiceHelloService()
				.getJwsServiceHelloPort();
		String name = hello.getValue("panchengming");
		System.out.println(name);
	}
}
