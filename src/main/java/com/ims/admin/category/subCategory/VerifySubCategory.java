package com.ims.admin.category.subCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class VerifySubCategory {
	SQLConnection sqlCon = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();

	public boolean verifySubCategory(int scid, String scName) {
		Connection cnn = sqlCon.sqlConnection();
		Statement st = null;
		final String MY_QUERY = "SELECT scNum, scName from SubCategory";
		try {
			st = cnn.createStatement();
			ResultSet resultSet = st.executeQuery(MY_QUERY);

			while (resultSet.next()) {
				int id = resultSet.getInt("scNum");
				String name = resultSet.getNString("scName");

				if (scName.equals(name) && (id == scid)) {
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
