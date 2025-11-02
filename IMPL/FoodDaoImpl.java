package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.FoodDao;
import POJO.Food;
import UTILITY.DBUtility;


public class FoodDaoImpl implements FoodDao{

	@Override
	public boolean AddFood(Food f) {
		
		Connection con=DBUtility.getConnection();
		String query="insert into Food(foodName,foodType,Categorey,descri,Price,image) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getCategorey());
			ps.setString(4, f.getDesc());
			ps.setDouble(5, f.getPrice());
			ps.setString(6, f.getImage());
			int count=ps.executeUpdate();
			if(count>0) {
				return true;
			}
			
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Food> GetAllFood() {
		
		
		
		
		 Connection con=DBUtility.getConnection();
		 String query="select * from Food";
		 
		 List<Food> list=new ArrayList<Food>();
		  
		  try {
			// using Statement 
			//Statement st=con.createStatement();
			  //ResultSet rs=st.executeQuery(query);
			 PreparedStatement ps=con.prepareStatement(query);
			 ResultSet rs=ps.executeQuery();
			 
		     //using PreparedStatement
			while(rs.next()) {
				Food f=new Food();
					 f.setFoodId(rs.getInt(1));
					 f.setFoodName(rs.getString(2));
					 f.setFoodType(rs.getString(3));
					 f.setCategorey(rs.getString(4));
					 f.setDesc(rs.getString(5));
					 f.setPrice(rs.getDouble(6));
					 f.setImage(rs.getString(7));
					
					 list.add(f);
			}
			
			
			con.close();
			ps.close();
			rs.close();
			
			// using Statement 
//			while(rs.next()) {
//			Food f=new Food(
//				rs.getInt(1),
//				rs.getString(2),
//				rs.getString(3),
//				rs.getString(4),
//				rs.getString(5),
//				rs.getDouble(6),
//				rs.getString(7)
//				);
//				
//				list.add(f);
//				
//			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  return list;
		  
	}

	@Override
	public boolean delete(int foodId) {
	
		Connection con=DBUtility.getConnection();
		String query="delete from Food where foodId=?";
		try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, foodId);
		int count=ps.executeUpdate();
		if(count>0) {
			return true;
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Food f) {
		
		Connection con=DBUtility.getConnection();
		
	    String query="update Food set foodName=?,foodType=?,Categorey=?,descri=?,Price=?,image=? where  foodId = ?";
	    
	    try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getCategorey());
			ps.setString(4, f.getDesc());
			ps.setDouble(5, f.getPrice());
			ps.setString(6, f.getImage());
			ps.setInt(7, f.getFoodId());
			
			int count=ps.executeUpdate();
			if(count>0) {
				return true;
			}
			
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Food SearchFoodById(int foodId) {
		
		
		Connection con=DBUtility.getConnection();
		String query="select * from Food where foodId=?";
		Food f=null;
				try {
		     PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, foodId);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				     f=new Food();
					 f.setFoodId(rs.getInt(1));
					 f.setFoodName(rs.getString(2));
					 f.setFoodType(rs.getString(3));
					 f.setCategorey(rs.getString(4));
					 f.setDesc(rs.getString(5));
					 f.setPrice(rs.getDouble(6));
					 f.setImage(rs.getString(7));	
			}
			
			con.close();
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return f;
	}

	@Override
	public List SearchFoodByType(String foodTy) {
		
		Connection con=DBUtility.getConnection();
		String query="select * from Food where foodType=?";
		
		List<Food> list1=new ArrayList<Food>();
		
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, foodTy.toLowerCase());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Food f=new Food();
				 f.setFoodId(rs.getInt(1));
				 f.setFoodName(rs.getString(2));
				 f.setFoodType(rs.getString(3));
				 f.setCategorey(rs.getString(4));
				 f.setDesc(rs.getString(5));
				 f.setPrice(rs.getDouble(6));
				 f.setImage(rs.getString(7));
				 
				 list1.add(f);
		}
		
		con.close();
		ps.close();
		rs.close();
		
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list1;
	}

	@Override
	public List SearchFoodByCategory(String foodCateg) {
		
		Connection con=DBUtility.getConnection();
		String query="select * from Food where Categorey=?";
		
		List<Food> list=new ArrayList<Food>();
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, foodCateg.toLowerCase());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				 f.setFoodType(rs.getString(3));
				 f.setCategorey(rs.getString(4));
				 f.setDesc(rs.getString(5));
				 f.setPrice(rs.getDouble(6));
				 f.setImage(rs.getString(7));
				 
				 list.add(f);
				 
			}
			
			con.close();
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	
}
