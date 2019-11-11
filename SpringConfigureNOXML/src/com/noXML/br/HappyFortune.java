package com.noXML.br;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class HappyFortune implements Fortune {

	 
	@Override
	public String getDailyFortune() {
		return "Your are sucessfull man";
	}
	

}
