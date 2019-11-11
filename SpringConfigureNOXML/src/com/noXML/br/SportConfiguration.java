package com.noXML.br;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.noXML.br")
@PropertySource("classpath:sport.properties")
public class SportConfiguration {

	@Bean
	public HappyFortune happyFortune() {
		return new HappyFortune();
	}
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(happyFortune());
	}	
	
}
