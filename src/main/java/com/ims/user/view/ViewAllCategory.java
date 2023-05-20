package com.ims.user.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class ViewAllCategory {
	SQLConnection sqlConn = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps = null;
	public void viewAllCategory() {
		Connection con = sqlConn.sqlConnection();
		final String View_QUERY = "select * from Category";

		try {
			ps = con.prepareStatement(View_QUERY);
			ResultSet rs = ps.executeQuery();
			System.out.println("-----------------");
			System.out.println("All Category Name");
			System.out.println("-----------------");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				
				System.out.println(name);
			}
			System.out.println("------------------");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlConnClose.sqlConnectionClose(con, ps);
		}
	}

}
