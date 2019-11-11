package com.well.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.well.entities.Instructor;
import com.well.entities.InstructorDetail;

public class RetrieveUPDInstructor {

	public static void main(String[] args) {
		
		 SessionFactory factory = new Configuration()
				 			.configure("hibernate.cfg.xml")
				 			.addClass(Instructor.class)
				 			.addClass(InstructorDetail.class)
				 			.buildSessionFactory();
		 
		 Session session = factory.getCurrentSession();
		 try {
			 
			 //Instructor instr = new Instructor();
			 //instr.setId(8);
			  
			 session.beginTransaction();
			 
			 Instructor instr = session.get(Instructor.class,8);
			 
			 System.out.println("Instructor: ");
			 System.out.println(instr);
			 
			 session.close();
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}finally {
			session.clear();
			factory.close();
		}
		 
		 
	}

}
