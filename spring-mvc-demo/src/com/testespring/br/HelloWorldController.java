package com.testespring.br;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	//need to create a map receive 
	@RequestMapping("/showform")
	public String helhoWorldForm() {
		return "helloword-form";
	}
	@RequestMapping("/helloworld")
	public String helhoWorld() {
		return "helloworld";
	}
	@RequestMapping("/helloWordVersionTwo")
	public String helloWordVersionTwo(HttpServletRequest request, Model model) {
		//recuperar o parametro
		String name = request.getParameter("estudante");
		
		//deixar em upper
		name = name.toUpperCase();
		
		//Criar a msg
		String result = "Yo! "+name;		
		
		//salvar no MODEL
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
}
