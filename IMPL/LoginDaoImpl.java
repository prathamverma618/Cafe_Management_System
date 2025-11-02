package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.LoginDao;
import UTILITY.DBUtility;

public class LoginDaoImpl implements LoginDao{

	@Override
	public boolean userLogin(String emailId, String Cpass) {
		
		Connection con=DBUtility.getConnection();
		String query="select * from Customer where email=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, emailId);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				
				String pass=rs.getString("pass");
				
				if(pass.equals(Cpass)) {
					return true;
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean adminLogin(String adminName, String adminPass) {
		
		Connection con=DBUtility.getConnection();
		String query="select * from admin12 where admin_email=? and admin_pass=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, adminName);
			ps.setString(2, adminPass);
			
		  ResultSet rs=ps.executeQuery();
		  
		  if(rs.next()) {
			  return true;
		  }
		  
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
