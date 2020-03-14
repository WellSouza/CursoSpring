package br.com.estudo.service;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.dao.CustomerDAO;
import br.com.estudo.entity.Customer;



@Service
public class CustomerServiceImpl implements CustomerService {
	

	@Autowired
	private CustomerDAO customerDAO;
		

	@Override
	@Transactional
	public boolean saveCustomer(Customer customer) {
		
		System.out.println("Customer For Save: "+customer.toString());
		return customerDAO.saveCustomer(customer);
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		
		return customerDAO.getCustomer(customerId);
	}

	@Override
	@Transactional
	public boolean delCustomer(int customerId) {
		 
		return customerDAO.delCustomer(customerId);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers(String nameSearch) {
		List<Customer> customers = null;
		
		if( nameSearch==null) {
			customers = customerDAO.getCustomers();
		}
		else {
			customers = customerDAO.getCustomers(nameSearch);
		}
		
		return customers;
	}
}
