package com.ibatis.action;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IbatisAction extends SqlMapClientDaoSupport{
	
	public void method01(){
		getSqlMapClientTemplate().queryForObject("com.ibatis.pojo.sel");
	}
	
}
