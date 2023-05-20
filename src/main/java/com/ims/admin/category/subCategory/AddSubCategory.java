package com.ims.admin.category.subCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class AddSubCategory {
	SQLConnection sqlCon = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps=null;
	Random rd = new Random();
	
	public void addSubCategory(int cNum, String scName) {
		Connection cnn = sqlCon.sqlConnection();
		int min = 100000, max=999999;
		int scNum = rd.nextInt((max - min + 1)) + min;
		final String ADD_QUERY = "insert into SubCategory values(?,?, ?)";
		
		try {
			ps =  cnn.prepareStatement(ADD_QUERY);
			ps.setInt(1, scNum);
			ps.setInt(2, cNum);
			ps.setString(3, scName);
			
			ps.executeUpdate();
			System.out.println("Sub Category Added sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Sub Category already exists!!!");
		}finally {
			sqlConnClose.sqlConnectionClose(cnn, ps);	
		}	
		
	}

}
