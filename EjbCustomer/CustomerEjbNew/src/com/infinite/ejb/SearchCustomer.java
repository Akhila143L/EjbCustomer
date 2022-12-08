package com.infinite.ejb;

import java.sql.SQLException;

import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SearchCustomer {

		public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
			int customerid;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Customer ID  ");
			customerid = sc.nextInt();
			CustomerBeanRemote service = null;
			    service = (CustomerBeanRemote)
			    		new InitialContext().lookup("CustomerBean/remote");
			    Customer customer = service.searchCustomer(customerid);
			if (customer!=null) {
				System.out.println(customer);
			}

			else {
				System.out.println("File not found ...");
			}

		}
}
