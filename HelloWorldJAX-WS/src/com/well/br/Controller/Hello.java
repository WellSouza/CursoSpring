package com.well.br.Controller;
 
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

import javax.jws.WebService;
import com.well.br.Entities.*;

@WebService (endpointInterface ="com.well.br.Controller.HelloWorld")
public class Hello implements HelloWorld {
	
	
	public Hello() {
		
	}
	
	@Override
	public String sayHello(String name) {
		return "hello, "+name;
	}

	@Override
	public String helloWorld() {
		return "Welcome jass";
	}

	@Override
	public TreeSet<String> sayHelloToAll(ArrayList<Users> name) {
		 
		TreeSet<String> set = new TreeSet<String>();
		
		for ( Users user : name) {	
			set.add(user.getName());
		}
		
		return set;
	}
}
