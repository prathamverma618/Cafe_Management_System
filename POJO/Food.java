package POJO;

import java.util.Iterator;

public class Food {

	
	private int foodId;
	private String foodName;
	private String foodType;
	private String Categorey;
	private String Desc; //Description
	private double Price;
	private String image;
	
	
	public Food() {
		super();
		
	}


	public Food(int foodId, String foodName, String foodType, String categorey, String desc, double price,
			String image) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodType = foodType;
		Categorey = categorey;
		Desc = desc;
		Price = price;
		this.image = image;
	}


	public Food(String foodName, String foodType, String categorey, String desc, double price, String image) {
		super();
		this.foodName = foodName;
		this.foodType = foodType;
		Categorey = categorey;
		Desc = desc;
		Price = price;
		this.image = image;
	}


	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

 
	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	public String getCategorey() {
		return Categorey;
	}


	public void setCategorey(String categorey) {
		Categorey = categorey;
	}


	public String getDesc() {
		return Desc;
	}


	public void setDesc(String desc) {
		Desc = desc;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", Categorey="
				+ Categorey + ", Desc=" + Desc + ", Price=" + Price + ", image=" + image + "]";
	}


	
	
	
	
	
}
