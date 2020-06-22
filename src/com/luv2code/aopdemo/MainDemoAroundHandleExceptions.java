package com.luv2code.aopdemo;

import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class MainDemoAroundHandleExceptions {

	private static Logger myLogger = 
			Logger.getLogger(MainDemoAroundHandleExceptions.class.getName());
	
	public static void main(String[] args) {
		
		//read spring config
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean 
		//update references
		TrafficFortuneService fortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("-------------------------");		
		myLogger.info("Calling getFortune");
		
		boolean falseFlag = false;
		
		myLogger.info("My fortune: " + fortuneService.getFortune(falseFlag));
		
		
		myLogger.info("Finished");
		myLogger.info("-------------------------");	
		//close context
		context.close();
	}
}
