package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMembershipAccount(Account account, boolean flag) {
		System.out.println(getClass()+": Doing my work: ADDING ACCOUNT");
		return true;
	}
	
	public boolean goSleep() {
		System.out.println(getClass()+": Going to sleep");
		return true;
	}
	
}
