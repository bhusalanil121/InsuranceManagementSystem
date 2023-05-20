package com.ims.databse.insert_update_delete_view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class UpdateUser {
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	SQLConnection sqlConn = new SQLConnection();

	public void updateUser(String firstName, String lastName, String email, String password, int id) {
		Connection cnn = sqlConn.sqlConnection();
		Statement st = null;
		final String UPDATE_USER = "update Users set firstName= " + firstName + ", lastName=" + lastName + ", email ="
				+ email + ", password=" + password + "where id = " + id;
		try {
			st = cnn.createStatement();
			int count = st.executeUpdate(UPDATE_USER);
			if (count != 0) {
				System.out.println("Data Update sucessfull");
			} else {
				System.out.println("Data Update unsucessfull");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlConnClose.sqlConnectionClose(cnn);
		}

	}

}
