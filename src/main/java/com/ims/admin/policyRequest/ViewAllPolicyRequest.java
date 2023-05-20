package com.ims.admin.policyRequest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;

public class ViewAllPolicyRequest {
	SQLConnection sqlConn = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps = null;
	Connection conn = null;
	ResultSet rs = null;
	
public void viewAllPolicyRequest() {
	conn = sqlConn.sqlConnection();
	final String VIEW_YOUR_POLICY_QUERY = "select * from PolicyRequest where status='pending'";
	
	try {
		ps = conn.prepareStatement(VIEW_YOUR_POLICY_QUERY);
	 rs = ps.executeQuery();
	 System.out.println("-----------------------------------------------------");
	 System.out.println("Email        id         Policy Name         Status");
	 System.out.println("-----------------------------------------------------");
	 while(rs.next()) {
		 String email = rs.getString(1);
		 int id = rs.getInt(2);
		 String pName = rs.getString(3);
		 String status = rs.getString(4);
		 System.out.println(email + "           "+ id + "        "+ pName + "        "+ status );
		 System.out.println();

	 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		sqlConnClose.sqlConnectionClose(conn, ps, rs);
	}
	
	
	
	
}
}

