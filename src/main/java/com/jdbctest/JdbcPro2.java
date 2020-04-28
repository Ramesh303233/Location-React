package com.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro2 {

	public static void main(String[] args) {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-66FNDLCV\\\\SQLEXPRESS:1433;databaseName=test", "TEST1234", "TEST1234");

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			
			// update query
			int result = stmt.executeUpdate("delete from location where id=17");

		
			
			// select query
			ResultSet rs = stmt.executeQuery("select * from Location");

			while (rs.next()) {
				System.out.println("id = " + rs.getInt(1) + "         City name = " + rs.getString(4));
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	
	}
}

// this is for insert 
//	int k = stmt.executeUpdate("insert into Location(code,type,name) values('CHN','URBAN','CHENNAI')");


//CURD





