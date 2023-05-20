package com.ims.admin.category.subCategory.policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class UpdatePolicy {
	SQLConnection sqlCon = new SQLConnection();
	PreparedStatement ps = null;
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();

	public void updatePolicy(int id, String name) {
		Connection conn = sqlCon.sqlConnection();
		final String UPDATE_QUERY = "update Policy set scName =? where scNum =?";
		try {
			ps = conn.prepareStatement(UPDATE_QUERY);
			ps.setString(1, name);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			System.out.println("Updated Sucessfully!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlConnClose.sqlConnectionClose(conn, ps);
		}

	}

}
