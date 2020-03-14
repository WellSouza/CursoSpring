package br.com.estudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.estudo.entity.Customer;
import br.com.estudo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String customersSearch(Model theModel, @RequestParam(value="paramName" , required=false)  String nameSearch ) {
		
		String findName =  nameSearch==null? "" : nameSearch; 
		System.out.println("valor a buscar :" + findName);
		
		//Recuperar Customers
		List<Customer> theCustomers = customerService.getCustomers(nameSearch);
		
		//atribuir ao model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer customer = new Customer();
		theModel.addAttribute("customer",customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		System.out.println("Customer For Save: "+theCustomer.toString());
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	@RequestMapping("/showFormForUpd") 
	public String showFormForUpd( Model theModel, @RequestParam("customerId") int customerId ) {
				
		Customer theCustomer = customerService.getCustomer(customerId);
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";  
	}
	@RequestMapping("/showFormForDel") 
	public String showFormForDel( Model theModel, @RequestParam("customerId") int customerId ) {
				
		boolean result = customerService.delCustomer(customerId);
		 
		return "redirect:/customer/list";
	}	
}
