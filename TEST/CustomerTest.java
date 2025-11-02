package TEST;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import IMPL.CustomerDaoImpl;
import POJO.Customer;

public class CustomerTest {
	
	public static boolean contnumonlynum(String contectnum){
		
		char ch[]=contectnum.toCharArray();
		for(char word:ch) {
			if(!Character.isLetter(word)) {
				return true;
			}
		}
		
		return false;
		
	}
	

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		 String custName; 
		 String emailId;
		 String custPassword;
		 String custAddress;
		 String contactNo;
		 String custLocation;
		 
		 CustomerDaoImpl custdaoimpl=new CustomerDaoImpl();
		 
		 
		 int choice;
		 boolean flag=false;
		 
		 
		 System.out.println("1. Add Customer: ");
		 System.out.println("2. Update Details of Customer: ");
		 System.out.println("3. Delete Customer: ");
		 System.out.println("4. show list of Customer: ");
		 System.out.println("5. Search by Email Id: ");
		 System.out.println("6. Return or Exit: ");
		 System.out.println();
		 System.out.println("Enter Your Choice: ");
		 choice=sc.nextInt();
		 sc.nextLine();
		 
		 switch(choice) {
		 case 1:
		 {
			 System.out.println("Enter Customer Name: ");
			 custName=sc.nextLine();
			 
			 System.out.println("Enter Customer EmailId: ");
			 emailId=sc.nextLine();

			 
			 System.out.println("Enter Customer Password: ");
			 custPassword=sc.nextLine();
			 
			 if(custPassword.length()!=6) {
				 System.out.println("Limit is 6");
				 break;
			 }
			 
			 System.out.println("Enter Customer Address: ");
			 custAddress=sc.nextLine();
			 
			 System.out.println("Enter Customer ContactNo: ");
			 contactNo=sc.nextLine();
			 
			 if(contactNo.length()!=10) {
				 System.out.println("Number will 10 digits");
			 }			 
			 
			 
			 if(contnumonlynum(contactNo)) {
				 System.out.println("Enter Only Number");
				 break;
			 }
			 

			 
			 
			 System.out.println("Enter Customer Loaction: ");
			 custLocation=sc.nextLine();
			 
			 Customer c=new Customer(custName, emailId, custPassword, custAddress, contactNo, custLocation);
			 flag=custdaoimpl.addCustomer(c);
			 if(flag) {
				 System.out.println("Customer Add Successfully!");
			 }else {
				 System.out.println("Not Add Customer");
			 }
			 
			
			 break;
		 }
		 
		 case 2:
		 {
			 System.out.println("Enter Customer EmailId: ");
			 emailId=sc.nextLine();
			 
			 System.out.println("Enter Customer Name: ");
			 custName=sc.nextLine();
			 
			 
			 System.out.println("Enter Customer Password: ");
			 custPassword=sc.nextLine();
			 
			 if(custPassword.length()!=6) {
				 System.out.println("Limit is 6");
				 break;
			 }
			 
			 System.out.println("Enter Customer Address: ");
			 custAddress=sc.nextLine();
			 
			 System.out.println("Enter Customer ContactNo: ");
			 contactNo=sc.nextLine();
			 
			 if(contactNo.length()!=10) {
				 System.out.println("Number will 10 digits");
				 break;
			 }			 
			 
			 
			 System.out.println("Enter Customer Loaction: ");
			 custLocation=sc.nextLine();
			 
			 Customer c=new Customer();
			 
			 c.setEmailId(emailId);
			 c.setCustName(custName);
			 c.setCustPassword(custPassword);
			 c.setCustAddress(custAddress);
			 c.setContactNo(contactNo);
			 c.setCustLocation(custLocation);
			 
			 flag=custdaoimpl.updateCustomer(c);
			 if(flag) {
				 System.out.println("Update Successfully!");
			 }else {
				 System.out.println("Not");
			 }
			 
			 break;
		 }
		 
		 case 3:
		 {
			 
			 System.out.println("Enter Customer EmailId: ");
			 emailId=sc.nextLine();
			 
			 flag=custdaoimpl.deleteCustomer(emailId);
			 if(flag) {
				 System.out.println("delete successfully");
			 }else {
				 System.out.println("Not deleted");
			 }
			 
			 
			 break;
		 }
		 
		 case 4:
		 {
			 List<Customer> l=custdaoimpl.GetAllCustomer();
			 
			 if(l!=null) {
				 
				 Iterator<Customer> it=l.iterator();
				 while(it.hasNext()) {
					 System.out.println(it.next());
				 }
				 
			 }
		 }
		 
		 case 5:
		 {
			 
			 System.out.println("Enter Customer EmailId: ");
			 emailId=sc.nextLine();
			 
			 Customer c=custdaoimpl.searchByEmailId(emailId);
			 
			 if(c!=null) {
				 System.out.println(c);
			 }
			 
			 break;
		 }
		 
		 case 6:
		 {
			 sc.close();
			 return;
		 }
		 
		 }
		
		

	}

}
