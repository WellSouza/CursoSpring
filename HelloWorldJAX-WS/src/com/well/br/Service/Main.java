package com.well.br.Service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.well.br.Controller.*;


public class Main {
	public static void main(String args[]) {
		
		try {
			
			Endpoint.publish("http://localhost:8080/Controller", new Hello());
			System.out.println("Done!");			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
