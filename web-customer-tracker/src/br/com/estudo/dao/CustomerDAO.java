package br.com.estudo.dao;

import java.util.List;

import br.com.estudo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public boolean saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public boolean delCustomer(int customerId);

	public List<Customer> getCustomers(String nameSearch);
}
