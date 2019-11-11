package com.estudante.springMVC.br;

import javax.servlet.http.HttpServletRequest;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
		
	@RequestMapping("/")
	public String showForm() {		
		return "main-menu";
	}
	@RequestMapping("/bemVindoForm")
	public String bemVindoForm() {		
		return "bem-vindo";
	}
	@RequestMapping("/showMessage")
	public String showMessageForm(HttpServletRequest request, Model model){
		
		String nome = request.getParameter("nomeAluno") == null ? "Nao pegou nome" : request.getParameter("nomeAluno").toString().toUpperCase();
		
		System.out.println(nome); 
		
		model.addAttribute("aluno",nome);
		
		return "message-form";
	}
	@RequestMapping("/showMessageModel")
	public String showMessageFormModel(@RequestParam String nomeAluno, Model model){
		
		//String nome = request.getParameter("nomeAluno") == null ? "Nao pegou nome" : request.getAttribute("nomeAluno").toString().toUpperCase();
		
		System.out.println(nomeAluno); 
		
		model.addAttribute("aluno",nomeAluno);
		
		return "message-form";
	}
}
