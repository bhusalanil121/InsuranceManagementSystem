package com.ims.admin.viewAllUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class ViewAllUsers {
SQLConnection sqlCon = new SQLConnection();
SQLConnectionClose sqlClose = new SQLConnectionClose();
PreparedStatement ps = null;
ResultSet rs = null;
	public void viewAllUsers() {
		
		Connection conn = sqlCon.sqlConnection();
		final String SELECT_ALL_USER = "select * from Users";
		try {
			ps = conn.prepareStatement(SELECT_ALL_USER);
			rs = ps.executeQuery();
			System.out.println("id       firstName      lastName        Email");
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String em = rs.getString(4);
				
				System.out.println(id + "      " + fn + "         "+ ln + "         "+ em);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			sqlClose.sqlConnectionClose(conn, ps, rs);
		}
	}
}
