package com.noXML.br;

import org.springframework.stereotype.Component;

@Component("TennisCoach")
public class TennisCoach implements Coach {
	
	public Fortune fortune;
	
	@Override
	public String somethingToDo() {
		return "Pratique muitas rebatidas!";
	}
	
	/*public String reportMsg() {
		return fortune.getDailyFortune();
	}*/
	 
	TennisCoach(Fortune thefortune){
		this.fortune = thefortune;
	}
}
