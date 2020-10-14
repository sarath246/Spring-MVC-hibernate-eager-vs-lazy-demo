package com.spring.mvc.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class Test_jdbc {

	public static void main(String[] args) {


		String jdbcUrl = "jdbc:mysql://localhost:3306/db_contact?useSSL=false";
		String user = "root";
		String pass = "root";

		
		try {

			
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn=DriverManager.getConnection( jdbcUrl, user, pass);
			System.out.println("Connection successfull!...");
		
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
