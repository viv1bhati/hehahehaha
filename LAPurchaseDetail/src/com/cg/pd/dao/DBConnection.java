package com.cg.pd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.pd.exception.PurchaseException;

public class DBConnection {

	private static Connection con;
	public static Connection getConnection() throws PurchaseException{
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String pwd = "corp123";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Class Loaded . .");
			con = DriverManager.getConnection(url, username, pwd);
			System.out.println("Connected . .");
		} catch (ClassNotFoundException e) {
			throw new PurchaseException();
		} catch (SQLException e) {
			throw new PurchaseException();
		}
		return con;
		
	}
	
	public static void main(String[] args) {
		
		try {
			getConnection();
		} catch (PurchaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}
