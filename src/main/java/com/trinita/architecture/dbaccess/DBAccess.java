package com.trinita.architecture.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBAccess {
	private static Connection conn;
	private static DataSource datasource;
	
	public static synchronized Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		datasource = (DataSource) context.lookup("java:/MySQL");
		conn = datasource.getConnection();
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

}
