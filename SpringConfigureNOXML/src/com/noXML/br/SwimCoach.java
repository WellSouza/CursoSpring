package com.noXML.br;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class SwimCoach implements Coach {
	public HappyFortune happyForturne;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return team;
	}
	SwimCoach(HappyFortune theHappyForturne ){
		happyForturne = theHappyForturne;
	}
	@Override
	public String somethingToDo() {		
		return "Nade muito tempo!";
	}

}
