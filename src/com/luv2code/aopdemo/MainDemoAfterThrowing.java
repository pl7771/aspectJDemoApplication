package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoAfterThrowing {

	public static void main(String[] args) {
		
		//read spring config
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		//get bean 
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		
		//call find accounts
		List<Account> accounts = null;
		
		try {
			//add boolean to simulate exception
			boolean flag = true;
			accounts = account.findAccounts(flag);
		} catch (Exception e) {
			System.out.println("Main programm caught exception: " + e);
		}
		
		//display accounts
		System.out.println("---------------------------------");
		System.out.println("In main: After Throwing demo app");
		System.out.println("All accounts: "+accounts);
		System.out.println("---------------------------------");
		//close context
		context.close();
	}

}
