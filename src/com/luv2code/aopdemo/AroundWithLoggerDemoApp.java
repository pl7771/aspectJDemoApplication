package com.luv2code.aopdemo;

import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
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
		myLogger.info("My fortune: " + fortuneService.getFortune());
		myLogger.info("Finished");
		myLogger.info("-------------------------");	
		//close context
		context.close();
	}

}
