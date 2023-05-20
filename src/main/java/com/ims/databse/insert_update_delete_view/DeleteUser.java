package com.ims.databse.insert_update_delete_view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class DeleteUser {
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	SQLConnection sqlConn = new SQLConnection();
	public void deleteUser(String email) {
		Connection cnn = sqlConn.sqlConnection();
		Statement st = null;
		final String DELETE_QUERY ="delete from Users where email="+email;
		
		try {
			st = cnn.createStatement();
			
			int count = st.executeUpdate(DELETE_QUERY);
			if (count != 0) {
				System.out.println("Data delete sucessfull");
			} else {
				System.out.println("Data delete unsucessfull");
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
