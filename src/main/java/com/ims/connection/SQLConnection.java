package com.ims.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	 

	public Connection sqlConnection() {
		Connection conn = null;
		try {
			// Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Create connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/insuranceManageSystem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "rootroot");
//			if (conn != null) {
//				System.out.println("Connection Sucessfull!!");
//
//			} else {
//				System.out.println("Connection unSucessfull!!!");
//			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return conn;

	}

}
