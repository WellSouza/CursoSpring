package br.relembradoBD.com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.relembrandoBD.com.etities.Classe;
import br.relembrandoBD.com.etities.UserDetail;
import br.relembrandoBD.com.etities.Users;

public class RetriveAndDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).
				addAnnotatedClass(Classe.class).
				addAnnotatedClass(UserDetail.class).
				buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			int theId = 38;

			session.beginTransaction();

			Users user = session.get(Users.class, theId);

			System.out.println("Users: " + user.toString());
						
			System.out.println("Users: " + user.getUserDetail().toString());

			List<UserDetail> listDetail = new ArrayList<>();

			listDetail = session.createQuery("from UserDetail d  where d.user = ?1", UserDetail.class)
					.setParameter(1, user).getResultList();
			
			for (UserDetail detail : listDetail) {
				System.out.println("Users: " + detail.toString());
			}
			
			for (Classe classe : user.getClasse()) {
				System.out.println("Classe: " + classe.toString());
			}
			

			UserDetail userDetailNew = new UserDetail();
			userDetailNew.setIdade(23);
			userDetailNew.setSexo("F");
			
			Users uNew = new Users();
			uNew.setNome("Carol");
			//uNew.Detail(userDetailNew);
			userDetailNew.setUser(uNew);
			
			
			System.out.println("New UserDT: "+ userDetailNew.toString());
			//System.out.println("New UserDT: "+ userDetailNew.getUser().toString());


			System.out.println("New User: "+ uNew.toString());
			//System.out.println("New User: "+ uNew.getUserDetail().toString());
			
			
			session.save(userDetailNew);
			session.getTransaction().commit();

			System.out.println("Save ok");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
