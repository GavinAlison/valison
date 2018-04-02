package com.alison.webservice.service.impl;

import javax.jws.WebService;

import com.alison.webservice.service.po.MyWebService;

//加上这个注解，表示此实现类就是WebService服务
@WebService(endpointInterface = "com.alison.webservice.service.po.MyWebService", name = "MyWebServiceImpl")
public class MyWebServiceImpl implements MyWebService {
	@Override
	public String method01(String name) {
		return name + "666";
	}

}
