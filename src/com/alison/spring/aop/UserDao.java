package com.alison.spring.aop;

public class UserDao implements IUserDao {
	@Override
	public void save() {
		System.out.println("-----核心业务：保存！！！------");
	}
}
