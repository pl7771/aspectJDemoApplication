package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean 
		//update references
		TrafficFortuneService fortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("Calling getFortune");
		System.out.println("My fortune: " + fortuneService.getFortune());
		//close context
		context.close();
	}

}
