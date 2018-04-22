package com.alison.jdbctemplate;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcTemplateDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employees", "root", "mysql");
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			conn.setAutoCommit(false);
			conn.getTransactionIsolation();
			
		} catch (Exception e) {

		}
	}
}
