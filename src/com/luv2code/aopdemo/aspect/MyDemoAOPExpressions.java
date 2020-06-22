package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyDemoAOPExpressions {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//pointcut for getters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//pointcut for setters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//COMBINE pointcut include package , but exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void includePackageExcludeGetSet() {}
	
	
}
