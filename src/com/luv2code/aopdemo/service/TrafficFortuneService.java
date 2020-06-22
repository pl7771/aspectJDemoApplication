package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Very heavy traffic is going on";
	}

	public String getFortune(boolean falseFlag) {
		if(falseFlag) {
			throw new RuntimeException("THIS IS SPART EXCEPTION!!!");
		}
		return getFortune();
	}
	
}
