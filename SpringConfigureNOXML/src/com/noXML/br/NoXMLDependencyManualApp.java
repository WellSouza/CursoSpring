package com.noXML.br;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXMLDependencyManualApp {

	public static void main(String[] args) {
		//
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfiguration.class);
		
		//Get the bean from the contenar 
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		
		//Do Sonething
		System.out.println(theCoach.somethingToDo());
		
		 System.out.println(theCoach.happyForturne.getDailyFortune());
		
		 System.out.println("Time: "+theCoach.getTeam() );
		 System.out.println("Email: "+theCoach.getEmail() );
		 
		 
		//Close the context
		context.close();
		
	}

}
