package com.well.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestesJDBC {

	public static void main(String[] args) {
		
		String jdbcURL 	= "jdbc:oracle:thin:@localhost:1521:orcl";
		String user		= "hbstudent";
		String pwd		= "hbstudent";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, user, pwd); 
					
					
			System.out.println("Sucessfull connected!");
			
			conn.close();
		}	
		catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		
		}
		
	}

}
