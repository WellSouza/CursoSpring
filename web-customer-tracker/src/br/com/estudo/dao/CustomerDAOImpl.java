package br.com.estudo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.estudo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override 
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

	@Override
	public boolean saveCustomer(Customer theCustomer) {
		
		//Recuperar a sessao corrente 
		Session theSession = sessionFactory.getCurrentSession();
		
		theSession.saveOrUpdate(theCustomer);
		
		System.out.println("Customer Adicionado!");
		
		return true;
	}

	@Override
	public Customer getCustomer(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = new Customer();
		
		Query<Customer> query = session.createQuery("from Customer where id = :customerId",Customer.class);
		
		
		customer = query.setParameter("customerId", customerId).getSingleResult();
		
		return customer;
	}

	@Override
	public boolean delCustomer(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		 
		query.executeUpdate();
		
		return true;
	}

	@Override
	public List<Customer> getCustomers(String nameSearch) {
		//Recuperar a sessao corrente 
		Session theSession = sessionFactory.getCurrentSession();

		//Criar a query
		Query<Customer> theQuery = 
				theSession.createNativeQuery("select * from Customer where regexp_like(first_name,:paramName,'i') or regexp_like(last_name, :paramName,'i') order by id",Customer.class).
				setParameter("paramName", nameSearch);
		
		
		System.out.println("Recuperando customers....");
		//recuperar os dados
		List<Customer> customers = theQuery.getResultList();
				
		//retornar os dados		
		System.out.println("Total de "+customers.size() + " Customers recuperados");
		
		return customers;
	}
	
	
}
