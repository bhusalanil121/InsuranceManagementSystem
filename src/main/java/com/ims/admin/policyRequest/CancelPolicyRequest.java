package com.ims.admin.policyRequest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class CancelPolicyRequest {
	SQLConnection sqlConn = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps = null;
	Connection conn = null;
	ResultSet rs = null;
	
public void cancelPolicyRequest(String emailToActivate) {
	conn = sqlConn.sqlConnection();
	final String VIEW_YOUR_POLICY_QUERY = "update PolicyRequest set=? where email=?";
	
	try {
		ps = conn.prepareStatement(VIEW_YOUR_POLICY_QUERY);
		ps.setString(1, "Cancled");
		ps.setString(2, emailToActivate);
	    ps.executeUpdate();
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		sqlConnClose.sqlConnectionClose(conn, ps, rs);
	}
	
	
	
	
}
}


