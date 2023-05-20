 package com.ims.admin.policyRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class VerifyEmail {
	SQLConnection sqlCon = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();

	public boolean verifyEmail(String Email) {
		Connection cnn = sqlCon.sqlConnection();
		Statement st = null;
		final String MY_QUERY = "SELECT email from PolicyRequest";
		try {
			st = cnn.createStatement();
			ResultSet resultSet = st.executeQuery(MY_QUERY);

			while (resultSet.next()) {
				String email = resultSet.getString("email");

				if (email.equals(Email)) {
					return true;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlConnClose.sqlConnectionClose(cnn);
		}

		return false;

	}

}
