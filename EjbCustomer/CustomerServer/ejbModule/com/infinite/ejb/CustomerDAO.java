package com.infinite.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CustomerDAO {
	Connection connection;
	PreparedStatement pst;
	
	public String updateCustomer(Customer customerNew) 
			throws ClassNotFoundException, SQLException {
		Customer customer = searchCustomer(customerNew.getCustomerid());
		if (customer!=null) {
			String cmd = "update customer set customerName=?, CustomerPhoneNo=?, gender=?, "
					+ " address1 =?, " + "address2 = ?, " + " zipcode =?, " + " city=? where customerid=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, customerNew.getCustomerName());
			pst.setString(2, customerNew.getCustomerPhoneNo());
			pst.setString(3, customerNew.getGender());
			pst.setString(4, customerNew.getAddress1());
			pst.setString(5, customerNew.getAddress2());
			pst.setString(6, customerNew.getZipcode());
			pst.setString(7, customerNew.getCity());
			pst.setInt(8, customerNew.getCustomerid());
			pst.executeUpdate();
			return "Customer Record Updated...";
		}
		return "Record Not Found...";
	} 
	public String deleteCustomer(int customerid)
			throws ClassNotFoundException, SQLException {
		Customer customer = searchCustomer(customerid);
		if (customer!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "delete from Customer where customerid=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, customerid);
			pst.executeUpdate();
			return "Record Deleted...";
		}
		return "Customer Record Not Found...";
	}
	public String addCustomer(Customer customer) 
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into customer(customerName,CustomerPhoneNo,gender,address1,address2,zipcode,city) "
				+ " values(?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, customer.getCustomerName());
		pst.setString(2, customer.getCustomerPhoneNo());
		pst.setString(3, customer.getGender());
		pst.setString(4, customer.getAddress1());
		pst.setString(5, customer.getAddress2());
		pst.setString(6, customer.getZipcode());
		pst.setString(7, customer.getCity());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Customer searchCustomer(int customerid)
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer where customerid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerid);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		if(rs.next()) {
			customer = new Customer();
			customer.setCustomerid(rs.getInt("customerid"));
			customer.setCustomerName(rs.getString("customerName"));
			customer.setCustomerPhoneNo(rs.getString("CustomerPhoneNo"));
			customer.setGender(rs.getString("gender"));
			customer.setAddress1(rs.getString("address1"));
			customer.setAddress2(rs.getString("address2"));
			customer.setZipcode(rs.getString("zipcode"));
			customer.setCity(rs.getString("city"));
		}
		return customer;
	}
	public List<Customer> showCustomer() throws 
				ClassNotFoundException, SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		while(rs.next()) {
			customer = new Customer();
			customer.setCustomerid(rs.getInt("customerid"));
			customer.setCustomerName(rs.getString("customerName"));
			customer.setCustomerPhoneNo(rs.getString("CustomerPhoneNo"));
			customer.setGender(rs.getString("gender"));
			customer.setAddress1(rs.getString("address1"));
			customer.setAddress2(rs.getString("address2"));
			customer.setZipcode(rs.getString("zipcode"));
			customer.setCity(rs.getString("city"));
				customerList.add(customer);
		}
		return customerList;
	}
}

