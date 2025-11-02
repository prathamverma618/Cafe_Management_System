package TEST;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import IMPL.CartDaoImpl;
import IMPL.FoodDaoImpl;
import IMPL.LoginDaoImpl;
import POJO.Cart;
import POJO.Food;

public class CartTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		boolean exit=true;
		boolean flag=false;
		
		LoginDaoImpl logindaoimpl=new LoginDaoImpl();
		CartDaoImpl cartdaoimpl=new CartDaoImpl();
		FoodDaoImpl fooddaoimpl=new FoodDaoImpl();
		
		 int cardId;
		 int foodId;
		 String castEmail;
		 int fquantity;
		 String fname;
		 double fprice;
		 double tottalPrice;
		
		
		
		System.out.println("Enter Email Id: ");
		String email=sc.nextLine();
		
		System.out.println("Enter Password: ");
		String pass=sc.nextLine();
		
		boolean login=logindaoimpl.userLogin(email, pass);
	     boolean admin_login=logindaoimpl.adminLogin(email, pass);
				
		
		if(login==true) {
			
			//System.out.println("Login Successfully!");
			
			do {
			
			
			
			System.out.println("1.Add to cart");
			System.out.println("2.Show my cart");
			System.out.println("3.Update quantity of item");
			System.out.println("4.Delete item from cart Id");
			System.out.println("5.Clear my cart Email");
			
			System.out.println("Enter Option: ");
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			
			case 1:{
				
				List<Food> list=fooddaoimpl.GetAllFood();
				
				for(Food f:list) {
					System.out.println(f);
					System.out.println("------------------------");
				}
				
				System.out.println("Enter id of food you want to add to cart");
				foodId=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Quantity of this food");
				fquantity=sc.nextInt();
				sc.nextLine();
				
				Cart cart=new Cart();
				cart.setFoodId(foodId);
				cart.setFquantity(fquantity);
				cart.setCastEmail(email);
				
				
				flag=cartdaoimpl.addToCart(cart);
				
				if(flag) {
					System.out.println("Food item added to cart Successfully!");
				}else {
					System.out.println("Not added to cart");
				}
				
				break;
			}
			
			case 2:
			{
				
				
				List<Cart> clist=cartdaoimpl.searchCartByEmailId(email);
				
				if(clist==null || clist.isEmpty()) {
					System.out.println("Your Cart is empty. Please add items");
				}else {
					
					double bill=0;
					
					for(Cart c:clist) {
						bill=bill+c.getTottalPrice();
						System.out.println(c);
						System.out.println("-----------------------------------------------");
					}
					
					System.out.println("Amount Payable: "+bill);
					
				}
				
                
				break;
			}
			
			case 3:
			{
				
				System.out.println("Enter Cart Id you want to be Update: ");
				cardId=sc.nextInt();
				
				System.out.println("Enter Update Food Quantity: ");
				fquantity=sc.nextInt();
				
			
				flag=cartdaoimpl.updateCart(cardId, fquantity);
				if(flag) {
					System.out.println("Quantity of your food item has been change Successfully!");
				}else {
					System.out.println("Error While chaning Quantity");
				}
				
				
				
				break;
			}
			
			
			case 4:
			{
				System.out.println("Enter Cart  Id you want to be Delete: ");
				cardId=sc.nextInt();
				
				flag=cartdaoimpl.deleteCartById(cardId);
				if(flag) {
					System.out.println("Item successfully deleted from cart");
				}else {
					System.out.println("Error while deleting item from cart!!!");
				}
				
				
				break;
			}
			
			
			case 5:
			{
				System.out.println("Are you sure want to clear your cart? Enter yes or no");
				String answer=sc.nextLine();
				//sc.nextLine();
				
				
				
				if(answer.equalsIgnoreCase("yes")) {
	
					
					flag=cartdaoimpl.deleteCartByEmail(email);
					if(flag) {
						System.out.println("Your cart is cleared. Please continue browsing for other items of your");
					}else {
						System.out.println("Error while clearing cart!!!");
					}
					
				}
				
				
				break;
			}
			
			}
			
			}while(exit==true);
			
		}else  if(admin_login){
			
			FoodTest.main(null);
			
		}else {
			System.out.println("Not Login");
		}
		
		

		
		
		
		

	}

}
