package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
import com.luv2code.aopdemo.dao.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {	
	
	private Logger myLogger = 
			Logger.getLogger(getClass().getName());
	
	@Around(
	"execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))"
	)
	public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable {
		//print out method we a re advising on
		String method = pjp.getSignature().toShortString();
		myLogger.info(">>>Executing @Around on method: " + method);
		//get begin timestamp
		long begin = System.currentTimeMillis();
		//execute the method
		//now with try catch
		Object result = null;
		try {
			result =  pjp.proceed();
		} catch (Exception e) {
			//log exception
			myLogger.warning(e.getMessage());
			//rethrow exception
			throw e;
		}
		//get ending time
		long end = System.currentTimeMillis();
		//display duration
		long duration = end - begin;
		myLogger.info(duration / 1000.0 + " seconds");
		return result;
	}
	
	
	@Before("com.luv2code.aopdemo.aspect.MyDemoAOPExpressions.includePackageExcludeGetSet()")
	public void log(JoinPoint joinPoint) {
		myLogger.info(">>>Logging stuff<<<");
		
		//display method signature
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		myLogger.info("   at Method "+signature);
		//display method arguments0
		Object args[] = joinPoint.getArgs();
		for(Object arg : args) {
			myLogger.info("   at "+arg);
			if(arg instanceof Account) {
				//downcast
				Account account = (Account) arg;
				myLogger.info("   at Account name: "+account.getName());
				myLogger.info("   at Account level: "+account.getLevel());			
			}
		}
	}	
	
	//add after returning 
	@AfterReturning(
				pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		//print method that we adviceing on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info(">>>Executing @Afterreturning on method: " + method);
		//print results of the methof call
		myLogger.info(">>>Result is: "+result);
		
		//post process data before returning data
		//convert name to uppercase for example
		convertAccountNamesToUpperCase(result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {		
		for(Account acc : result) {
			String upperName = acc.getName().toUpperCase();
			acc.setName(upperName);
		}		
	}
	
	//add after throwing exception
	@AfterThrowing(
				pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
				throwing = "myException"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable myException) {
		//print what method we advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info(">>>Executing @AfterThrowing on method: " + method);
		//log the exception
		myLogger.info(">>>Exception is: " + myException);
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		//print what method we advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info(">>>Executing @After finally on method: " + method);
		
	}
	
	
}
