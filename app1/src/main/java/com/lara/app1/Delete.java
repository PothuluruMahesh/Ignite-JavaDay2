package com.lara.app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	public static void Main(String[] args) throws SQLException, ClassNotFoundException
	{
		// Register JDBC driver
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

		// Open JDBC connection
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
		try (Statement stmt = conn.createStatement()) {

		    // Delete from Person
		    stmt.executeUpdate("DELETE FROM Person WHERE name = 'John Doe'");
		}
		
	}

}
