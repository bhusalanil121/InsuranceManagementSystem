package com.ims.admin.category.subCategory.policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class VerifyPolicy {
	SQLConnection sqlCon = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();

	public boolean verifyPolicy(int pNum, String pName) {
		Connection cnn = sqlCon.sqlConnection();
		Statement st = null;
		final String MY_QUERY = "SELECT pNum, pName from Policy";
		try {
			st = cnn.createStatement();
			ResultSet resultSet = st.executeQuery(MY_QUERY);

			while (resultSet.next()) {
				int id = resultSet.getInt("pNum");
				String name = resultSet.getNString("pName");

				if (pName.equals(name) && (id == pNum)) {
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
