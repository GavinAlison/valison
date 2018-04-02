package com.alison.webservice.service.impl;

import javax.jws.WebService;

import com.alison.webservice.service.po.MyWebService;

//加上这个注解，表示此实现类就是WebService服务
@WebService
public class MyWebServiceImpl implements MyWebService {
	@Override
	public String method01() {
		return "666";
	}

}
