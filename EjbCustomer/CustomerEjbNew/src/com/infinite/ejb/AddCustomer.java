package com.infinite.ejb;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;
public class AddCustomer {
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.println("Enter CustomerName  ");
		customer.setCustomerName(sc.next());
		System.out.println("Enter CustomerPhoneNo  ");
		customer.setCustomerPhoneNo(sc.next());
		System.out.println("Enter Gender  ");
		customer.setGender(sc.next());
		System.out.println("Enter Address1   ");
		customer.setAddress1(sc.next());
		System.out.println("Enter Address2   ");
		customer.setAddress2(sc.next());
		System.out.println("Enter Zipcode   ");
		customer.setZipcode(sc.next());
		System.out.println("Enter City   ");
		customer.setCity(sc.next());		
		CustomerBeanRemote service = null;
			    service = (CustomerBeanRemote)
		    		new InitialContext().lookup("CustomerBean/remote");
		    System.out.println(service.addCustomer(customer));
	}
}
