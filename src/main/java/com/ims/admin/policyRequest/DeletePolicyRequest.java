package com.ims.admin.policyRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class DeletePolicyRequest {
	SQLConnection sqlConn = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps = null;
	Connection conn = null;
	
public void dancelPolicyRequest(String emailToDelete) {
	conn = sqlConn.sqlConnection();
	final String DELETE_POLICY_REQUEST_QUERY = "delete from PolicyRequest where email=?";

	try {
		ps = conn.prepareStatement(DELETE_POLICY_REQUEST_QUERY);
		ps.setString(1, emailToDelete);
	    ps.executeUpdate();
	    
	    
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		sqlConnClose.sqlConnectionClose(conn, ps);
	}
	
	
	
	
}
}


