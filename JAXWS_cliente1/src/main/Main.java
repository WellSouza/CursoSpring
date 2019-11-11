package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import Controller.*;

public class Main {

	public static void main(String[] args) {
		
		try {
			HelloService helloService = new HelloServiceLocator();
			HelloWorld hello = helloService.getHelloPort();
			
			System.out.println(hello.helloWorld());
			
			System.out.println(hello.sayHello("Welington"));
			
			
			Users[] names = new Users[4]; 
			names[0] = (new Controller.Users(1,"Carlos"));
			names[2] =(new Controller.Users(3,"joão"));
			names[1] =(new Controller.Users(6,"Miguel"));
			names[3] =(new Controller.Users(31,"Philipe"));
			

			
			 String[] set = hello.sayHelloToAll(names);
			
			for (String nome : set) {
				
				System.out.println(nome);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
