package com.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro1 {

	public static void main(String[] args) {

		System.out.println("Start Program");
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-66FNDLCV\\\\SQLEXPRESS:1433;databaseName=test", "TEST1234", "TEST1234");
			
			//System.out.println(con);
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
			ResultSet rs = stmt.executeQuery("select * from Location");
			

			while (rs.next()) {
				System.out.println("id = "+rs.getInt(1)+"         City name = "+rs.getString(4));
			}

		con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
