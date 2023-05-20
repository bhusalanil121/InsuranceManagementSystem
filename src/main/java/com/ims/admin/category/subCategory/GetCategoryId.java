package com.ims.admin.category.subCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;

public class GetCategoryId {
	SQLConnection sqlCon = new SQLConnection();

	public int getCategoryId(int subCatId) {
		Connection conn = sqlCon.sqlConnection();
		PreparedStatement ps = null;
		final String SELECT_QUERY = "select * from SubCategory";
		
		try {
			ps = conn.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("scNum");
				int cid = rs.getInt("cNum");
				if(id == subCatId) {
					return cid;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	

}
