package com.sitit23.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public Connection con = null;
	
	public Connection dbConnection() {
		try {
			
			System.out.println("Connecting...");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sitit23", "root", "");
			System.out.println("Connected...");
			
		} catch (Exception e) {
			// TODO: handle exception
//			System.out.println(e);
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection dc = new DbConnection();
		dc.dbConnection();
	}

}
