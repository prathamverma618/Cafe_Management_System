package DAO;

import java.util.List;

import POJO.Customer;

public interface CustomerDao {

	public boolean addCustomer(Customer c);
	public boolean updateCustomer(Customer c1);
	public boolean deleteCustomer(String emailId);
	
	public Customer searchByEmailId(String emailId);
	
	List<Customer> GetAllCustomer();
	
	
}
