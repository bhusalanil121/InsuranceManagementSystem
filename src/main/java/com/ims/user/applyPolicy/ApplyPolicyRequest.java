package com.ims.user.applyPolicy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;

public class ApplyPolicyRequest {
	SQLConnection sqlCon = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps=null;
	Random rd = new Random();
	
	public void applyPolicyRequest(String policyName, int policyNum, int subCatNum, int catNum) {
		Connection cnn = sqlCon.sqlConnection();
		final String ADD_QUERY = "insert into PolicyRequest values(?,?,?,?,?,?)";
		
		try {
			ps =  cnn.prepareStatement(ADD_QUERY);
			ps.setString(1, HomePage.USER);
			ps.setInt(2, policyNum);
			ps.setString(3, policyName);
			ps.setString(4, "Pending");
			ps.setInt(5, subCatNum);
			ps.setInt(6, catNum);
			
			ps.executeUpdate();
			
			System.out.println("Policy Applied sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Category already exists!!!");
		}finally {
			sqlConnClose.sqlConnectionClose(cnn, ps);	
		}
		
		
		

	}

}
