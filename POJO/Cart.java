package POJO;

public class Cart {

	private int cardId;
	private int foodId;
	private String castEmail;
	private int fquantity;
	private String fname;
	private double fprice;
	private double tottalPrice;
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int cardId, int foodId, String castEmail, int fquantity, String fname, double fprice,
			double tottalPrice) {
		super();
		this.cardId = cardId;
		this.foodId = foodId;
		this.castEmail = castEmail;
		this.fquantity = fquantity;
		this.fname = fname;
		this.fprice = fprice;
		this.tottalPrice = tottalPrice;
	}

	
	

	public Cart(int foodId, String castEmail, int fquantity, String fname, double fprice, double tottalPrice) {
		super();
		this.foodId = foodId;
		this.castEmail = castEmail;
		this.fquantity = fquantity;
		this.fname = fname;
		this.fprice = fprice;
		this.tottalPrice =tottalPrice;
	}

	

	public int getCardId() {
		return cardId;
	}


	public void setCardId(int cardId) {
		this.cardId = cardId;
	}


	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public String getCastEmail() {
		return castEmail;
	}


	public void setCastEmail(String castEmail) {
		this.castEmail = castEmail;
	}


	public int getFquantity() {
		return fquantity;
	}


	public void setFquantity(int fquantity) {
		this.fquantity = fquantity;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public double getFprice() {
		return fprice;
	}


	public void setFprice(double fprice) {
		this.fprice = fprice;
	}


	public double getTottalPrice() {
		return tottalPrice;
	}


	public void setTottalPrice(double tottalPrice) {
		this.tottalPrice = tottalPrice;
	}


	@Override
	public String toString() {
		return "Cart [cardId=" + cardId + ", foodId=" + foodId + ", castEmail=" + castEmail + ", fquantity=" + fquantity
				+ ", fname=" + fname + ", fprice=" + fprice + ", tottalPrice=" + tottalPrice + "]";
	}
	
	
	
	
	
}
