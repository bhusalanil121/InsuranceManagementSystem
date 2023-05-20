package com.ims.databse.insert_update_delete_view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class AddUser {
	Random rand = new Random();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	SQLConnection sqlConn = new SQLConnection();
	PreparedStatement ps = null;
	Connection conn = null;
	public void addUser(String firstName, String lastName, String email, String password) {
		Connection cnn = sqlConn.sqlConnection();
		Statement st = null;
		int min = 100000, max=999999;
		int id = rand.nextInt((max - min + 1)) + min;
		
		
		String INSERT_USER = "insert into Users values(?,?,?,?,?)";

		try {
			conn = sqlConn.sqlConnection();
			ps = conn.prepareStatement(INSERT_USER);
			ps.setInt(1, id);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setString(5, password);
			
			int count = ps.executeUpdate();
			
			if (count != 0) {
				System.out.println("Data insertion sucessfull");
			} else {
				System.out.println("Data insertion unsucessfull");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			sqlConnClose.sqlConnectionClose(cnn);
		}
		
		
	}

}
