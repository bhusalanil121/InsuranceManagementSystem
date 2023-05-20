package com.ims.databse.insert_update_delete_view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class VerifyUser {
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	SQLConnection sqlConn = new SQLConnection();
	
	public boolean verifyUser(String Email, String Password ) {
		Connection cnn = sqlConn.sqlConnection();
		Statement st = null;
		final String MY_QUERY = "SELECT email, password from Users";
		try {
			st = cnn.createStatement();
			ResultSet resultSet = st.executeQuery(MY_QUERY);
			
			while(resultSet.next()) {
				String email = resultSet.getNString("email");
				String password = resultSet.getNString("password");
				
				if(email.equals(Email) && password.equals(Password)) {
					return true;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlConnClose.sqlConnectionClose(cnn);
		}
		
		return false;
	}

}
