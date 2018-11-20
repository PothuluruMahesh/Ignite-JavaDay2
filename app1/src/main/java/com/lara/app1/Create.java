package com.lara.app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
	public static void Main(String[] args) throws SQLException, ClassNotFoundException
	{
		// Register JDBC driver
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

		// Open JDBC connection
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
		// Create database tables
		try (Statement stmt = conn.createStatement()) {

		    // Create table based on REPLICATED template
		    stmt.executeUpdate("CREATE TABLE City (" + 
		    " id LONG PRIMARY KEY, name VARCHAR) " +
		    " WITH \"template=replicated\"");

		    // Create table based on PARTITIONED template with one backup
		    stmt.executeUpdate("CREATE TABLE Person (" +
		    " id LONG, name VARCHAR, city_id LONG, " +
		    " PRIMARY KEY (id, city_id)) " +
		    " WITH \"backups=1, affinityKey=city_id\"");
		}
	}

}
