package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CustomerDao;
import POJO.Customer;
import UTILITY.DBUtility;

public class CustomerDaoImpl  implements CustomerDao{

	@Override
	public boolean addCustomer(Customer c) {
		
		Connection con=DBUtility.getConnection();
		String query="insert into Customer(cname,email,pass,address,contactno,location) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, c.getCustName());
			ps.setString(2, c.getEmailId());
			ps.setString(3, c.getCustPassword());
			ps.setString(4, c.getCustAddress());
			ps.setString(5, c.getContactNo());
			ps.setString(6, c.getCustLocation());
			
			int count=ps.executeUpdate();
			
			if(count>0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Email Not");
			e.printStackTrace();
			
		}
		
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c1) {
		
		Connection con=DBUtility.getConnection();
		String query="update Customer set cname=?,pass=?,address=?,contactno=?,location=? where email=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, c1.getCustName());
			ps.setString(2, c1.getCustPassword());
			ps.setString(3, c1.getCustAddress());
			ps.setString(4, c1.getContactNo());
			ps.setString(5, c1.getCustLocation());
			ps.setString(6, c1.getEmailId());
			
			int count=ps.executeUpdate();
			if(count>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteCustomer(String emailId) {
		
		Connection con=DBUtility.getConnection();
		String query="delete from Customer where email=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, emailId);
			int count=ps.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Customer searchByEmailId(String emailId) {
		
            Connection con=DBUtility.getConnection();
            String query="select * from Customer where email=?";
            
            try {
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, emailId);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					
					Customer c=new Customer();
					c.setCustName(rs.getString(1));
					c.setEmailId(rs.getString(2));
					c.setCustPassword(rs.getString(3));
					c.setCustAddress(rs.getString(4));
					c.setContactNo(rs.getString(5));
					c.setCustLocation(rs.getString(6));
					
					return c;
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
            
		
		return null;
	}

	@Override
	public List<Customer> GetAllCustomer() {
		
		Connection con=DBUtility.getConnection();
		String query="select * from Customer";
		
		List<Customer> list=new ArrayList<Customer>();
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Customer c=new Customer();
				c.setCustName(rs.getString(1));
				c.setEmailId(rs.getString(2));
				c.setCustPassword(rs.getString(3));
				c.setCustAddress(rs.getString(4));
				c.setContactNo(rs.getString(5));
				c.setCustLocation(rs.getString(6));
				
				list.add(c);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
