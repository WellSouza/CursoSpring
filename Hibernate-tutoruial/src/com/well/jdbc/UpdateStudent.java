package com.well.jdbc;
 

import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.well.entities.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		
	SessionFactory  sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();	
	
	Session session = sessionFactory.getCurrentSession();
	
	try {
		
		Student std = new Student();
		std.setId(21);
		
		
		session.beginTransaction();
		
		std = session.get(Student.class, std.getId());
		std.setFirstname("Jõao");
		
		session.update(std);		
		System.out.println("Student: ");
		System.out.println(std);		
		
		List<Student> students = session.createQuery("from Student").getResultList();
		System.out.println("All of them : ");
		for (Student student : students) {
			System.out.println(student);
		}
		session.getTransaction().commit();
	
		session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("Total atualizados: "+
				session.createQuery("update from Student set first_name = 'Marcos' where first_name = :nome ")
				.setParameter("nome", "Jõao")
				.executeUpdate() )		;
		
		students = session.createQuery("from Student").getResultList();
		System.out.println("All of them : ");
		for (Student student : students) {
			System.out.println(student);
		}
		
		session.getTransaction().commit();
		
	} catch (Exception e) {
		System.out.println("Error:  "+e.getMessage());
	}finally {
		sessionFactory.close();
		session.close();
	}
	}
}		