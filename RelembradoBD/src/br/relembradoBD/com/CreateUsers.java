package br.relembradoBD.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.relembrandoBD.com.etities.UserDetail;
import br.relembrandoBD.com.etities.Users;

public class CreateUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory  factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Users.class).
				addAnnotatedClass(UserDetail.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Users user = new Users();
		user.setNome("Welington");
			
		UserDetail userDetail = new UserDetail();
		userDetail.setIdade(18);
		userDetail.setSexo("M");
		
		userDetail.setUser(user);
		
		try {
			
			session.beginTransaction();
			
			session.joinTransaction();
			
			session.save(userDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Sucesso ao efetuar operacação!");
			
		}catch(Exception e) {
			System.out.println("Error ao processar: "+e.getMessage());
			System.out.println(e.getStackTrace());
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
