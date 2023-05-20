package com.ims.user.applyPolicy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class GetPolicyId {
	SQLConnection sqlCon = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	public int getPolicyId(String pName) {
		Connection cnn = sqlCon.sqlConnection();
		Statement st = null;
		final String MY_QUERY = "SELECT * from Policy";
		try {
			st = cnn.createStatement();
			ResultSet resultSet = st.executeQuery(MY_QUERY);

			while (resultSet.next()) {
				String name = resultSet.getNString("pName");
				int id = resultSet.getInt("pNum");
				
				if (pName.equals(name)) {
					return id;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlConnClose.sqlConnectionClose(cnn);
		}
		return 0;
	}

}
