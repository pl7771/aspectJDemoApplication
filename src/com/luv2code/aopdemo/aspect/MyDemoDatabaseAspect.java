package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoDatabaseAspect {

	@Before("com.luv2code.aopdemo.aspect.MyDemoAOPExpressions.includePackageExcludeGetSet()")
	public void log3() {
		System.out.println(">>>Getting to database<<<");
	}
	
}
