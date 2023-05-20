package com.ims.user.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class ViewAllSubCategory {
	SQLConnection sqlConn = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps = null;
	public void viewAllSubCategory() {
		Connection con = sqlConn.sqlConnection();
		final String View_QUERY = "select * from SubCategory";

		try {
			ps = con.prepareStatement(View_QUERY);
			ResultSet rs = ps.executeQuery();
			System.out.println("--------------------");
			System.out.println(" Sub Category Name  ");
			System.out.println("--------------------");
			while (rs.next()) {
				String name = rs.getString(3);
				
				System.out.println( name);
			}
			System.out.println("--------------------");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlConnClose.sqlConnectionClose(con, ps);
		}
	}

}
