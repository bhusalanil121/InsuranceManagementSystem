package com.ims.admin.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class AddCategory {
	SQLConnection sqlCon = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps=null;
	Random rd = new Random();
	
	public void addCategory(String cName) {
		Connection cnn = sqlCon.sqlConnection();
		int min = 100000, max=999999;
		int cNum = rd.nextInt((max - min + 1)) + min;
		final String ADD_QUERY = "insert into Category values("+ cNum+ ", ?)";
		
		try {
			ps =  cnn.prepareStatement(ADD_QUERY);
			ps.setString(1, cName);
			ps.executeUpdate();
			System.out.println("Category Added sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Category already exists!!!");
		}finally {
			sqlConnClose.sqlConnectionClose(cnn, ps);	
		}
		
		
		
	}

}
