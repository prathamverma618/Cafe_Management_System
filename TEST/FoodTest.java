package TEST;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import IMPL.FoodDaoImpl;
import POJO.Food;

public class FoodTest {

	public static void main(String[] args) {
		
		int foodId;
		 String foodName;
		 String foodType;
		 String Categorey;
		 String Desc; //Description
		 double Price;
		 String image;
		FoodDaoImpl fdilmpl=new FoodDaoImpl();
		
		boolean flag;
		
		Scanner sc=new Scanner(System.in);
		int choice;
		
		System.out.println(" 1.AddFood\n 2.GetAllFood\n 3.DeleteFood\n 4.UpdateFood\n 5.SearchFood\n 6.SearchFoodType\n 7.SearchFoodCategory");
		System.out.println("Enter your choice: ");
		choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		
		case 1:
		{
			System.out.println("Enter Food Name");
			foodName=sc.nextLine();
           // sc.nextLine();
			 System.out.println("Enter Food Type");
		     foodType=sc.nextLine();
		   
		   System.out.println("Enter Food Category");
		   Categorey=sc.nextLine();
		   
		   System.out.println("Enter Food Desc");
		   Desc=sc.nextLine();
		   
		   System.out.println("Enter Food Price");
		   Price=sc.nextDouble();
		   sc.nextLine();
		   System.out.println("Enter Food Image");
		   image=sc.nextLine();
		  
		   
		   Food f=new Food(foodName, foodType, Categorey, Desc, Price, image);
		   flag=fdilmpl.AddFood(f);
		   if(flag) {
			   System.out.println("Inserted Food successfully");
		   }else {
			   System.out.println("Not Inserted");
		   }
		   break;
		}
		
		
		
		case 2:
		{
			List<Food> f=fdilmpl.GetAllFood();
			if(f!=null) {
				
				Iterator<Food>  it=f.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
			}
			
			break;
		}
		
			
		
		case 3:
		{
			System.out.println("Enter FoodId that food want to delete: ");
			 foodId=sc.nextInt();
			 flag=fdilmpl.delete(foodId);
			 if(flag) {
				 System.out.println("delete successfully");
			 }else {
				 System.out.println("not delete");
			 }
			 break;
		}
		
	
		
		case 4:
		{
			System.out.println("Enter FoodId that food want to update: ");
			foodId=sc.nextInt();
			 sc.nextLine();
			System.out.println("Enter Food Name");
			foodName=sc.nextLine();
           // sc.nextLine();
			
		    System.out.println("Enter Food Type");
		    foodType=sc.nextLine();
		   
		   System.out.println("Enter Food Category");
		   Categorey=sc.nextLine();
		   
		   System.out.println("Enter Food Desc");
		   Desc=sc.nextLine();
		   
		   System.out.println("Enter Food Price");
		   Price=sc.nextDouble();
		   sc.nextLine();
		   System.out.println("Enter Food Image");
		   image=sc.nextLine();
		   
		   
		   Food f=new Food();
		   f.setFoodId(foodId);
		   f.setFoodName(foodName);
		   f.setFoodType(foodType);
		   f.setCategorey(Categorey);
		   f.setDesc(Desc);
		   f.setPrice(Price);
		   f.setImage(image);
		   flag=fdilmpl.update(f);
		   if(flag) {
			   System.out.println("Successfully Updated");
		   }else {
			   System.out.println("Not Updated");
		   }
		   
		   break;
		}
		
		
		case 5:
		{
		
			System.out.println("Enter FoodId that you want to search: ");
			int foodId1 = sc.nextInt();

			// Call method from your DAO/Service implementation class
			Food f = fdilmpl.SearchFoodById(foodId1);

			if (f != null) {
				
				System.out.println(f);
				
//			    System.out.println("Food Found:");
//			    System.out.println("ID: " + f.getFoodId());
//			    System.out.println("Name: " + f.getFoodName());
//			    System.out.println("Type: " + f.getFoodType());
//			    System.out.println("Category: " + f.getCategorey());
//			    System.out.println("Description: " + f.getDesc());
//			    System.out.println("Price: " + f.getPrice());
//			    System.out.println("Image: " + f.getImage());
			} else {
			    System.out.println("Food with ID " + foodId1 + " not found.");
			}

			break;
		}
		
		case 6:
		{
			System.out.println("Enter FoodType that you want to search: ");
		    foodType = sc.nextLine();
			
			List<Food> f1= fdilmpl.SearchFoodByType(foodType);
			
			if(f1!=null) {
				
				Iterator<Food> it1=f1.iterator();
				while(it1.hasNext()) {
					System.out.println(it1.next());
				}
				
			}
			
			break;
		}
			
		
		case 7:
		{
			System.out.println("Enter FoodCategorey that you want to search: ");
			Categorey = sc.nextLine();
			
			List<Food> f2=fdilmpl.SearchFoodByCategory(Categorey);
			
			if(f2!=null) {
				
				Iterator<Food> it2=f2.iterator();
				while(it2.hasNext()) {
					System.out.println(it2.next());
				}
				
			}
			
			break;
		}
		
		
		}

	}

}
