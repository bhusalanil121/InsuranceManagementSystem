package com.ims.admin.category.subCategory.policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;

public class AddPolicy {
	SQLConnection sqlCon = new SQLConnection();
	SQLConnectionClose sqlConnClose = new SQLConnectionClose();
	PreparedStatement ps = null;
	Random rd = new Random();

	public void addPolicy(int scNum, String pName, int cNum) {
		Connection cnn = sqlCon.sqlConnection();
		int min = 100000, max = 999999;
		int pNum = rd.nextInt((max - min + 1)) + min;
		final String ADD_QUERY = "insert into Policy values(?,?, ?,?)";

		try {
			ps = cnn.prepareStatement(ADD_QUERY);
			ps.setInt(1, pNum);
			ps.setString(2, pName);
			ps.setInt(3, cNum);
			ps.setInt(4, scNum);
			ps.executeUpdate();
			System.out.println("Policy Added sucessfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Sub Category already exists!!!");
		} finally {
			sqlConnClose.sqlConnectionClose(cnn, ps);
		}

	}

}
