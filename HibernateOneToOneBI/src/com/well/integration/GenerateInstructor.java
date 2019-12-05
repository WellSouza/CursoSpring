package com.well.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.well.entities.Instructor;
import com.well.entities.InstructorDetail;

public class GenerateInstructor {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			System.out.println("Criando novo Instrutor...");
			Instructor inst = new Instructor("Carolina","Ana","Cana@hotmail.com");
			
			System.out.println("Criando novo Detalhe do Instrutor...");
			InstructorDetail instDetail = new InstructorDetail("cana.youtube.com","Show");
			
			instDetail.setInstructor(inst);
			
			session.joinTransaction();
			
			session.saveOrUpdate(instDetail);			
			session.getTransaction().commit();
			
			
			System.out.println("Then it is Done!");
			System.out.println(instDetail);
			System.out.println(inst);
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}finally {
			session.close();
			factory.close();
		}
	}

}
