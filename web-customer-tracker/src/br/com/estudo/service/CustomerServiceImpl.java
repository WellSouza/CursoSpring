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
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}
