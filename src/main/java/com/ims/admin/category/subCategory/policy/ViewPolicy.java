package com.ims.admin.category.subCategory.policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class ViewPolicy {
	SQLConnection sqlConn = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps = null;

	public void viewPolicy() {
		Connection con = sqlConn.sqlConnection();
		final String View_QUERY = "select * from Policy";

		try {
			ps = con.prepareStatement(View_QUERY);
			ResultSet rs = ps.executeQuery();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("policy id        policy Name      Category id         Sub Category id");
			System.out.println("-------------------------------------------------------------------------");
			while (rs.next()) {
				int pid = rs.getInt(1);
				String name = rs.getString(2);
				int cNum = rs.getInt(3);
				int scNum = rs.getInt(4);
				
				System.out.println(pid + "         " + name+ "            " + cNum+ "          " + scNum);
			}
			System.out.println("-------------------------------------------------------------------------");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlConnClose.sqlConnectionClose(con, ps);
		}

	}

}
