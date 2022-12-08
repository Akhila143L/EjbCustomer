package com.infinite.ejb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgentShowServlet
 */
@WebServlet("/ShowCustomerServlet")

public class ShowCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerBeanRemote service=null;
		PrintWriter out=response.getWriter();
		
			try {
				service=(CustomerBeanRemote) new InitialContext().lookup("CustomerBean/remote");
				List<Customer> customerList=service.showCustomer();
				out.println("<table border=1 ");
				 out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>CustomerPhoneNo</th><th>Gender</th><th>Address1</th><th>Address2</th><th>Zipcode</th><th>City</th><tr>");
				for (Customer customer : customerList) {
					
					 
					out.println("<tr><td>"+customer.getCustomerid()
							+ "</td><td>"+customer.getCustomerName()+"</td><td>"+customer.getCustomerPhoneNo()+"</td><td>"+customer.getGender()
							+"</td><td>"+customer.getAddress1()+"</td><td>"+customer.getAddress2()+"</td><td>"+customer.getZipcode()+"</td><td>"+customer.getCity()+"</td></tr>");
					
				}out.println("</table>"); 
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
