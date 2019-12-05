package com.well.ba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.internal.expression.function.LowerFunction;

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
			 
			 Instructor instr = session.get(Instructor.class,22);
			 
			 System.out.println("Instructor: ");
			 System.out.println(instr);
			 
			 instr.setEmail((instr.getFirst_name()+instr.getLastName()).toLowerCase()+"@xpto.com");
			 
			 session.update(instr);
			 
			 session.getTransaction().commit();
			 System.out.println("Instructor Atualizado: "+instr);
			 session.close();
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}finally {
			session.close();
			factory.close();
		}
		 
		 
	}

}
