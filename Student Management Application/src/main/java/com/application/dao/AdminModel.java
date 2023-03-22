package com.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.application.dto.Admin;
import com.util.DatabaseConnection.DBConnection;

public class AdminModel {


	private Connection connection = null;
	private PreparedStatement pstmt = null;
	
	
	public Boolean check(String email,String password) {
		
		Boolean flag = false;
		
		try {
			connection = DBConnection.connect();
			String query = "select aemail, apassword from admin";
			pstmt = connection.prepareStatement(query);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			if(resultSet != null) {
				if(resultSet.next()) {
					if(email.equals(resultSet.getString("aemail")) && 
							password.equals(resultSet.getString("apassword"))) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
}
