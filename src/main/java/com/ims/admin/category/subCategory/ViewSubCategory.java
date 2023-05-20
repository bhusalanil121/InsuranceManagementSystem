package com.ims.admin.category.subCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class ViewSubCategory {
	SQLConnection sqlConn = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps = null;

	public void viewSubCategory() {
		Connection con = sqlConn.sqlConnection();
		final String View_QUERY = "select * from SubCategory";

		try {
			ps = con.prepareStatement(View_QUERY);
			ResultSet rs = ps.executeQuery();
			System.out.println("---------------------------------------------------------");
			System.out.println("Sub Category id        Sub Category Name      Category id ");
			System.out.println("---------------------------------------------------------");
			while (rs.next()) {
				int scNum = rs.getInt(1);
				int cNum = rs.getInt(2);
				String name = rs.getString(3);
				
				System.out.println(scNum + "                  " + name+ "                 " + cNum);
			}
			System.out.println("---------------------------------------------------------");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlConnClose.sqlConnectionClose(con, ps);
		}

	}

}
