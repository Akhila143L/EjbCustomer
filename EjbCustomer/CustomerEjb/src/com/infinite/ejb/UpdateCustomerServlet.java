package com.infinite.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgentUpdateServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerBeanRemote service=null;
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("customerid"));
		String customerName=request.getParameter("customerName");
		String customerPhoneNo=request.getParameter("customerPhoneNo");
		String gender=request.getParameter("gender");
		String address1=request.getParameter("address1");
		String address2=request.getParameter("address2");
		String city=request.getParameter("city");
		String zipcode=request.getParameter("zipcode");
		Customer customer=new Customer();
		 customer.setCustomerName(customerName);
		 customer.setCustomerPhoneNo(customerPhoneNo);
		 customer.setAddress1(address1);
		 customer.setAddress2(address2);
		 customer.setCity(city);
		 customer.setZipcode(zipcode);
		try {
			service=(CustomerBeanRemote) new InitialContext().lookup("CustomerBean/remote");
			out.println(service.updateCustomer(customer));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}