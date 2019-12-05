package com.well.ba;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.internal.expression.function.LowerFunction;

import com.well.entities.Instructor;
import com.well.entities.InstructorDetail;

public class RetrieveDeleteInstructor {

	public static void main(String[] args) {
		
		 SessionFactory factory = new Configuration()
				 			.configure("hibernate.cfg.xml")
				 			.addAnnotatedClass(Instructor.class)
				 			.addAnnotatedClass(InstructorDetail.class)
				 			.buildSessionFactory();
		 
		 Session session = factory.getCurrentSession();
		 try {
			 
			  
			 session.beginTransaction();
			 
			List<Integer> ids = session.createQuery("select distinct i.id from Instructor i, InstructorDetail d where i.id = d.id")
						.getResultList();	
			
			Random rd = new Random(); 
					
			System.out.println("Ids no DB: "+ids.toString());
			 
			int i = ids.get( rd.nextInt(ids.size() )); 
			
			System.out.println("ID: "+i);
			Instructor instr = session.get(Instructor.class,i);
			 
			System.out.println("Instructor: ");
			 System.out.println(instr);
			 
			 if(instr != null ) {
				 
				 //session.delete(instr);
				 //Outro jeito
				 
				 session.createQuery("delete from Instructor i where i.id = :id_user ")
				 			.setParameter("id_user", i)
				 			.executeUpdate();
				 
				 //session.refresh(Instructor.class);
			 } 
			else {
				System.out.println("User nao existe"); 
			 }
			 session.getTransaction().commit();
			 System.out.println("Instructor deletado: "+instr);
			 
			 session.close();
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}finally {
			session.close();
			factory.close();
		}
		 
		 
	}

}
