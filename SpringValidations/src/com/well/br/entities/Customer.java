package com.well.br.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.*;

import com.well.br.validation.CourseCode;


public class Customer {

	private String firstName;
	
	@NotNull(message="Informe valor")
	@Size(min=1,message="is required")
	private String lastName;
	
	private String radioBotao;
	
	@CourseCode(value={"LUV","TOPS","BEST"},message="Deve iniciar com \"LUV\" ou \"TOPS\" ou\"BEST\"")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getRadioBotao() {
		return radioBotao;
	}

	public void setRadioBotao(String radioBotao) {
		this.radioBotao = radioBotao;
	}
	
		
	private String pais; 
	
	@NotNull(message="Informe valor")
	//@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Informe apenas numeros")
	@Min(value = 1,message="Deve Ser maior igual 1")
	@Max(value = 50,message="Deve Ser menor igual 50 ")
	//@Pattern(regexp="^[0-9]",message="Informe apenas numeros")
	private Integer price;
	
	public Integer getPrice() {
		return price;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	private String language;	
	private Map<String,String> optionLang;
	 
	public String getFirstName() {
		return firstName;
	}	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Map<String, String> getOptionLang() {
		return optionLang;
	}

	public Customer() {
		optionLang = new HashMap<>();
		optionLang.put("Java", "Java");
		optionLang.put("Delph", "Delph");
		optionLang.put("PLSQL", "PLSQL");
		optionLang.put("C#", "C#");
	}

	//public void addAttribute(String string, Map<String, String> optionsCountry) {
	//} 
	 

}
