package com.ims.admin.category.subCategory.policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;

public class GetSubCategoryId {
	SQLConnection sqlCon = new SQLConnection();

	public int getSubCategoryId(int policyId) {
		Connection conn = sqlCon.sqlConnection();
		PreparedStatement ps = null;
		final String SELECT_QUERY = "select * from Policy";
		
		try {
			ps = conn.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int scNum = rs.getInt("scNum");
				int pid = rs.getInt("pNum");
				if(pid == policyId) {
					return scNum;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
