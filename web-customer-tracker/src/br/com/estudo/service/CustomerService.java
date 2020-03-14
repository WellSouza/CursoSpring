package br.com.estudo.service;

import java.util.List;

import br.com.estudo.entity.Customer;

public interface CustomerService {	
	
	public Customer getCustomer(int customerId);
	
	public boolean saveCustomer(Customer customer);

	public boolean delCustomer(int customerId);

	public List<Customer> getCustomers(String nameSearch);
	
}
