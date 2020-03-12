package br.com.estudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.estudo.entity.Customer;
import br.com.estudo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Recuperar Customers
		List<Customer> theCustomers = customerService.getCustomers();
		
		//atribuir ao model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}

}
