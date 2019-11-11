package com.well.jdbc;
 

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.well.entities.Student;

public class GetStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
				
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//Start a transaction
			session.beginTransaction();
			
			/*int id = 3;
			System.out.println("Geting Student ID: "+id);
			
			Student student = session.get(Student.class, id);
			
			System.out.println("Student: "+student);
			*/
			
			
			System.out.println("Geting all Students: ");
			
			List<Student> students = session.createQuery(" from Student "
														+ "where id between ?1 and ?2 "
														+ "order by id asc")
								.setParameter(1,2)
								.setParameter(2,20)
								.getResultList();
			
			for (Student std : students) {
				System.out.println(std);
			}
			
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
