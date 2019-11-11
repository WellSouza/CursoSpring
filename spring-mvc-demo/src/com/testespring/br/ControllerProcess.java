package com.testespring.br;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerProcess {
	
	@RequestMapping("/")	
	 public String showMyPage() {
		 return "main-menu";
	 }

}
