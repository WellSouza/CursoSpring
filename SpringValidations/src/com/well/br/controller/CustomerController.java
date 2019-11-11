package com.well.br.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.well.br.entities.*;



@Controller
@RequestMapping("/Customer")
public class CustomerController {
	
	@Value("#{countryOptions}") 
	private Map<String,String> optionsCountry;
	
	public String getOptionsCountry( String Key) {
		return optionsCountry.get(Key);
	}
	@RequestMapping("showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer",new Customer());
		
		theModel.addAttribute("theCountry",optionsCountry);
		
		return "customer-form";
	}
	@RequestMapping("processForm")
	public String processForm( Model theCountry,
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResul) {
				 
		theCountry.addAttribute("theCountry",optionsCountry);
		
		theCountry.addAttribute("descPais",getOptionsCountry(theCustomer.getPais()));
		System.out.println("#######################################################");
		System.out.println(theBindingResul);
		System.out.println("\n\n\n\n\n\n");
		System.out.println(theBindingResul.hasErrors());		
		System.out.println("#######################################################");
		
		System.out.println(theBindingResul.hasFieldErrors()  ? "customer-form" :  "customer-confirmation");
		System.out.println("#######################################################");
		
		return theBindingResul.hasErrors() ? "customer-form" :  "customer-confirmation";
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimerEditor = new StringTrimmerEditor(true);
		 
		dataBinder.registerCustomEditor(String.class, stringTrimerEditor);
	}
	
}
