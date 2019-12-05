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
				 			.addAnnotatedClass(Instructor.class)
				 			.addAnnotatedClass(InstructorDetail.class)
				 			.buildSessionFactory();
		 
		 Session session = factory.getCurrentSession();
		 try {
			 
			 //Instructor instr = new Instructor();
			 //instr.setId(8);
			  
			 session.beginTransaction();
			 
			 InstructorDetail instr = session.get(InstructorDetail.class,22);
			 
			 System.out.println("Instructor: ");
			 System.out.println(instr.getInstructor());
			 
			 System.out.println("Instructor Detail: ");
			 System.out.println(instr);
			 
			 System.out.println("Atualizando Instructor: ");
			 instr.getInstructor().setLastName("Lazaro");
			 instr.getInstructor().setFirst_name("Lazaro");
			
			 session.saveOrUpdate(instr);
			
			 System.out.println("Atualizando com Sucesso ");
			 //session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}finally {
			session.clear();
			factory.close();
		}
		 
		 
	}

}
