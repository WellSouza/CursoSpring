package com.noXML.br;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXMLApp {

	public static void main(String[] args) {
		//
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfiguration.class);
		
		//Get the bean from the contenar 
		TennisCoach theCoach = context.getBean( TennisCoach.class);
		
		//Do Sonething
		System.out.println(theCoach.somethingToDo());
		
		 System.out.println(theCoach.fortune.getDailyFortune());
		
		//Close the context
		context.close();
		
	}

}
