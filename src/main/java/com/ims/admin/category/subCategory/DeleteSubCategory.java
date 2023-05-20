package com.ims.admin.category.subCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class DeleteSubCategory {
	SQLConnection sqlCon = new SQLConnection();
	PreparedStatement ps = null;
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	
	public void deleteSubCategory(int scid) {
		Connection cnn =  sqlCon.sqlConnection();
		final String DELETE_QUERY = "delete from SubCategory where scNum =?";
		final String DELETE_POLICY = "delete from Policy where scNum =?";
		final String DELETE_POLICY_Request = "delete from PolicyRequest where scid =?";
		
		try {
			ps = cnn.prepareStatement(DELETE_QUERY);
			ps.setInt(1,scid );
			ps.executeUpdate();
			
			
			//Delete Policy
			ps = cnn.prepareStatement(DELETE_POLICY);
			ps.setInt(1,scid );
			ps.executeUpdate();
			
			//Delete Policy Request
			ps = cnn.prepareStatement(DELETE_POLICY_Request);
			ps.setInt(1,scid );
			ps.executeUpdate();
			
			System.out.println("Delete Sucessfull!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
