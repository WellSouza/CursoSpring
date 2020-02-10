package br.relembradoBD.com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.relembrandoBD.com.etities.Classe;
import br.relembrandoBD.com.etities.UserDetail;
import br.relembrandoBD.com.etities.Users;

public class CreateUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory  factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Users.class).
				addAnnotatedClass(UserDetail.class).
				addAnnotatedClass(Classe.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Users user = new Users();
		user.setNome("Carmelita");
			
		UserDetail userDetail = new UserDetail();
		userDetail.setIdade(54);
		userDetail.setSexo("M");
				
		Classe classe1 = new Classe();
		classe1.setCurso("Geografia");
		classe1.setUser(user);
		
		Classe classe2 = new Classe();
		classe2.setCurso("Matemática");
		//classe2.setUser(user);
		
		List<Classe> classe = new ArrayList<>(); 
		classe.add(classe2);
		//classe.add(classe1);
		
		
		//user.setUserDetail(userDetail);	
		user.add(classe2);
		user.add(classe1);
		userDetail.setUser(user);	
		
		System.out.println("Passo 1");
		
		
		System.out.println("Passo 1");
		System.out.println("User: "+user.toString());
		System.out.println("Passo 2");
		System.out.println("UserDetail: "+userDetail.toString());
		System.out.println("Passo 3");
		System.out.println("Classe: "+classe1.toString());
		System.out.println("Passo 4");
		System.out.println("Classe: "+classe2.toString());
		System.out.println("Passo 5");
		
		try {
			
			session.beginTransaction();
			
			
			session.save(classe1);
			//session.save(classe.get(1));
			
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
