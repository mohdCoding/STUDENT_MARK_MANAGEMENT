package com.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnection {

	private DBConnection() {

	}

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static Connection connection = null;

	public static Connection connect() throws SQLException {
		HikariConfig config = new HikariConfig(
				"E:\\Student Management System\\Student Management Application\\src\\main\\java\\com\\application\\properties\\db.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		if (connection == null)
			connection = dataSource.getConnection();
		return connection;
	}

}
