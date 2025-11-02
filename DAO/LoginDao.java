package DAO;

public interface LoginDao {

	public boolean userLogin(String emailId,String Cpass);
	public boolean adminLogin(String adminName,String adminPass);
	
}
