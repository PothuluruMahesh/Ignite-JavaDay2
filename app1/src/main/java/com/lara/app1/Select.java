package com.lara.app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static void Main(String[] args) throws SQLException, ClassNotFoundException
	{
		// Register JDBC driver
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

		// Open JDBC connection
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
		try (Statement stmt = conn.createStatement()) 
		{
		    try (ResultSet rs =
		    stmt.executeQuery("SELECT p.name, c.name " +
		    " FROM Person p, City c " +
		    " WHERE p.city_id = c.id")) {

		      System.out.println("Query result:");

		      while (rs.next())
		         System.out.println(">>>    " + rs.getString(1) + ", " + rs.getString(2));
		    }
		}
	}
}
