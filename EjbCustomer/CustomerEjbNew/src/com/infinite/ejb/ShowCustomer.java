package com.infinite.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
public class ShowCustomer {
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		CustomerBeanRemote service = null;

		    // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

		    // service = (HelloService)new
		    // InitialContext().lookup("java:comp/env/ejb/HelloService");
		    service = (CustomerBeanRemote)
		    		new InitialContext().lookup("CustomerBean/remote");

		    List<Customer> customerList = service.showCustomer();
		    for (Customer customer : customerList) {
				System.out.println(customer);
			}
	}
}
