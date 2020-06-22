package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		//get bean 
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO account2 = context.getBean("membershipDAO", MembershipDAO.class);
		//call business method
		
		account.setName("Ilya");
		account.setLevel("Level 1");
		
		account.getName();
		account.getLevel();
		System.out.println();
		
		account.addAccount();
		System.out.println();
		
		account.doWork();
		System.out.println();
		
		Account acc = new Account();
		account2.addMembershipAccount(acc, true);
		System.out.println();
		
		account2.goSleep();
		System.out.println();
		account.addAccount();
		
		
		//close context
		context.close();
	}

}
