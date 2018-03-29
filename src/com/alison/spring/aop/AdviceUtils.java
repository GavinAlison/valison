package com.alison.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class AdviceUtils implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("before  around advice==============");
		Object result = methodInvocation.proceed();
		System.out.println("after around advice==============");
		return result;
	}
}
