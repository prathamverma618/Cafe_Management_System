package DAO;

import java.util.List;

import POJO.Food;

public interface FoodDao {

	public boolean AddFood(Food f);
	List<Food> GetAllFood();
	public boolean delete(int foodId);
	public boolean update(Food f);
	public Food SearchFoodById(int foodId);
    List SearchFoodByType(String foodTy);
    List SearchFoodByCategory(String foodCateg);

    
	
}
