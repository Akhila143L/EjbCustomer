package com.infinite.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CustomerBean
 */
@Stateless
@Remote(CustomerBeanRemote.class)
public class CustomerBean implements CustomerBeanRemote {
static CustomerDAO cdao;
	
	static {
		cdao = new CustomerDAO();
	}
    
    public CustomerBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Customer> showCustomer() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return cdao.showCustomer();
	}

	@Override
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return cdao.addCustomer(customer);
	}

	@Override
	public String updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return cdao.updateCustomer(customer);
	}

	@Override
	public Customer searchCustomer(int customerid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return cdao.searchCustomer(customerid);
	}

}
