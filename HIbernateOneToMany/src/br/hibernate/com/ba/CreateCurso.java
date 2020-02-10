package br.hibernate.com.ba;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.hibernate.com.etities.Course;
import br.hibernate.com.etities.Student;

public class CreateCurso {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Course.class).
								addAnnotatedClass(Student.class).
								buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		try {
			
			
			Course course = new Course();
			course.setTitle("Portugues Moderno");
			session.beginTransaction();
			
			System.out.println("Curso :"+course);
			session.save(course);
			
			
			
			Student std1 = new Student("Marcos","Polo","mp@mail.com");
			Student std2 = new Student("Joao","bezerra","jb@mail.com");
			course.add(std1);
			course.add(std2);
			
			System.out.println("Estudantes+ "+course.getStudent());
			session.save(std1);
			session.save(std2);
			
			session.getTransaction().commit();
			
			System.out.println("Operação realizada!");
			
		}catch (Exception e) {
			System.out.println("\nErro ao processar!");
			System.out.println("Erro:"+e.getMessage());
			
		}finally {
			session.close();
			factory.close();
		}			
	}
}