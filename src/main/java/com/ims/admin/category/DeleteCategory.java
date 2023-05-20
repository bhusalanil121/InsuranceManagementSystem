package com.ims.admin.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class DeleteCategory {
	SQLConnection sqlCon = new SQLConnection();
	PreparedStatement ps = null;
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	public void deleteCategory(int cid) {
		Connection cnn =  sqlCon.sqlConnection();
		final String DELETE_QUERY = "delete from Category where cNum =?";
		final String DELETE_SUB_CATEGORY = "delete from SubCategory where cNum =?";
		final String DELETE_POLICY = "delete from Policy where cNum =?";
		final String DELETE_POLICY_Request = "delete from PolicyRequest where cid =?";

		try {
			//Delete Category
			ps = cnn.prepareStatement(DELETE_QUERY);
			ps.setInt(1,cid );
			ps.executeUpdate();
			
			//Delete Sub Category
			ps = cnn.prepareStatement(DELETE_SUB_CATEGORY);
			ps.setInt(1,cid );
			ps.executeUpdate();
			
			//Delete Policy
			ps = cnn.prepareStatement(DELETE_POLICY);
			ps.setInt(1,cid );
			ps.executeUpdate();
			
			//Delete Policy Request
			ps = cnn.prepareStatement(DELETE_POLICY_Request);
			ps.setInt(1,cid );
			ps.executeUpdate();
			
			
			
			System.out.println("Delete Sucessfull!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
