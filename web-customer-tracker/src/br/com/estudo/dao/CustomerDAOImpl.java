package br.com.estudo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(){
		
		//Recuperar a sessao corrente 
		Session theSession = sessionFactory.getCurrentSession();

		//Criar a query
		Query<Customer> theQuery = 
				theSession.createQuery("from Customer order by first_name",Customer.class);
		
		System.out.println("Recuperando customers....");
		//recuperar os dados
		List<Customer> customers = theQuery.getResultList();
				
		//retornar os dados
		
		System.out.println("Total de "+customers.size() + " Customers recuperados");
		
		return customers;
	}
}
