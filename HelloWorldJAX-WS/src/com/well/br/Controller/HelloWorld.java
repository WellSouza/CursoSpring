package com.well.br.Controller;

import java.util.ArrayList;
import java.util.TreeSet;

import com.well.br.Entities.*;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorld {
	
	@WebMethod
	public String helloWorld();
	
	@WebMethod
	public String sayHello(String Name);
	
	@WebMethod
	public TreeSet<String> sayHelloToAll(ArrayList<Users> name);
	
}
