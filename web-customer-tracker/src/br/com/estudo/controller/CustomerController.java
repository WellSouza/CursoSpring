package br.com.estudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.estudo.entities.Customer;
import br.com.etudo.dao.CustomerDAO;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	 
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Recuperar Customers
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//atribuir ao model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}

}
