package com.sitit23.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sitit23.dbconnection.DbConnection;
import com.sitit23.vo.ResultVO;
import com.sitit23.vo.UserVO;

public class UserDaoImpl {
	
	ResultVO rvo = new ResultVO();
	public Connection con = null;
	public PreparedStatement ps = null;
	DbConnection dc = new DbConnection();
	
	public ResultVO dataInsert(UserVO uvo) {
		try {
//			Take the data from Servlet
			String name = uvo.getName();
			String stream = uvo.getStream();
			String email = uvo.getEmail();
			String city = uvo.getCity();
			
//			Check your DBConnection
			con = dc.dbConnection();
			
//			Execute the SQL Query
			String insertQuery = "INSERT INTO itstudents VALUES(DEFAULT, ?, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, name);
			ps.setString(2, stream);
			ps.setString(3, email);
			ps.setString(4, city);
			
//			Check the transaction status
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Success");
			}
			else {
				System.out.println("Failed");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rvo;
	}
	

}
