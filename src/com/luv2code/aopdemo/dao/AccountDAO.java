package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private String level;
	
	public List<Account> findAccounts(boolean flag){
		
		
		//axception simulate
		if(flag) {
			throw new RuntimeException("THIS IS SPARTA EXCEPTION!!!");
		}
		
		List<Account> accounts = new ArrayList<>();
		//sample accounts
		accounts.add(new Account("Ilya", "level 5"));
		accounts.add(new Account("Lera", "level 2"));
		accounts.add(new Account("Mary", "level 1"));
		return accounts;
	}
	
	public String getName() {
		System.out.println(getClass()+": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": setName()");
		this.name = name;
	}

	public String getLevel() {
		System.out.println(getClass()+": getLevel()");
		return level;
	}

	public void setLevel(String level) {
		System.out.println(getClass()+": setLevel()");
		this.level = level;
	}

	public void addAccount() {
		System.out.println(getClass()+": Doing my work: ADDING ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": Doing WORK");
		return true;
	}
	
}
