package com.well.jdbc;
 

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.well.entities.Student;

public class GenerateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
				
		Session session = factory.getCurrentSession();
		
		try {
			
			//Create student object
			Student std = new Student("Welington","Souza","WellSouza@email01");
			
			System.out.println("Creating new Student: "+std.toString());
			
			//Start a transaction
			session.beginTransaction();
			
			//save the Student object
			session.save(std);

			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
			
		}finally {
			System.out.println("Finally closing connection!");
			factory.close();
		}
				

	}

}
