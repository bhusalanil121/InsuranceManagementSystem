package com.ims.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnectionClose {
	public void sqlConnectionClose(Connection c) {
		if (c != null) {
			
					try {
						c.close();
//						System.out.println("Connection Close Sucessfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
		}
	public void sqlConnectionClose(Connection c, PreparedStatement ps) {
		if (c != null) 
		{
			
					try {
						c.close();
						ps.close();
//						System.out.println("Connection Close Sucessfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
		
		}
	public void sqlConnectionClose(Connection c, PreparedStatement ps, ResultSet rs) {
		if (c != null) 
		{
			
					try {
						c.close();
						ps.close();
						rs.close();
//						System.out.println("Connection Close Sucessfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
		
		}
	}


