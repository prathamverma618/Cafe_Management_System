package DAO;

import java.util.List;

import POJO.Cart;

public interface CartDao {

	public boolean addToCart(Cart cart);
	List<Cart> showCartList();
	List<Cart> searchCartByEmailId(String cEamil);
	List<Cart> searchById(int cartid);
	public boolean deleteCartById(int cartid);
	public boolean deleteCartByEmail(String cemail);
    public boolean updateCart(int cartid,int fquantity);
	
}
