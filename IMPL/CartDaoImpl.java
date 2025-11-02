package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CartDao;
import POJO.Cart;
import POJO.Food;
import UTILITY.DBUtility;

public class CartDaoImpl implements CartDao{

	@Override
	public boolean addToCart(Cart cart) {
		
		Connection con=DBUtility.getConnection();
		String query="insert into cart1(fid,cemail,fquantity,fname,fprice,totalprice) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			
//			Food f=new Food();
//			FoodDaoImpl fooddaoimpl=new FoodDaoImpl();
//			fooddaoimpl.SearchFoodById(cart.getFoodId());
			
			Food f=new FoodDaoImpl().SearchFoodById(cart.getFoodId());
			
			ps.setInt(1, cart.getFoodId());
			ps.setString(2, cart.getCastEmail());
			ps.setInt(3, cart.getFquantity());
			ps.setString(4,f.getFoodName());
			
			ps.setDouble(5, f.getPrice());
			
			double totalprice=f.getPrice()*cart.getFquantity();
			
			ps.setDouble(6,totalprice);
			
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
	public List<Cart> showCartList() {
		
		Connection con=DBUtility.getConnection();
		String query="select * from cart1";
		
		List<Cart> list=new ArrayList<Cart>();
		
		
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {
				
				Cart c=new Cart();
				c.setCardId(rs.getInt(1));
				c.setFoodId(rs.getInt(2));
				c.setCastEmail(rs.getString(3));
				c.setFquantity(rs.getInt(4));
				c.setFname(rs.getString(5));
				c.setFprice(rs.getDouble(6));
				c.setTottalPrice(rs.getDouble(7));
				
				list.add(c);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<Cart> searchCartByEmailId(String cEamil) {
		
		Connection con=DBUtility.getConnection();
		String query="select * from cart1 where cemail=?";
		
		List<Cart> list=new ArrayList<Cart>();
		
		Cart c=null;
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, cEamil);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {
				
				c=new Cart();
				c.setCardId(rs.getInt(1));
				c.setFoodId(rs.getInt(2));
				c.setCastEmail(rs.getString(3));
				c.setFquantity(rs.getInt(4));
				c.setFname(rs.getString(5));
				c.setFprice(rs.getDouble(6));
				c.setTottalPrice(rs.getDouble(7));
				
				list.add(c);
			}
		
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	@Override
	public List<Cart> searchById(int cartid) {
		
		
		
		
		return null;
	}

	@Override
	public boolean deleteCartById(int cartid) {
		
		Connection con=DBUtility.getConnection();
        String query="delete from cart1";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, cartid);
			
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
	public boolean deleteCartByEmail(String cemail) {
		
        Connection con=DBUtility.getConnection();
        String query="delete from cart1 where cemail=?";
		
        try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, cemail);
			
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
	public boolean updateCart(int cartid, int fquantity) {
		
		Connection con=DBUtility.getConnection();
		String query="update cart1 set fquantity=?,totalprice=fquantity*fprice  where cid=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, fquantity);
			ps.setInt(2, cartid);
			
			int count=ps.executeUpdate();
			if(count>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}
