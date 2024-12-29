//package com.cdac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
//@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 PrintWriter  out = response.getWriter();
		 response.setContentType("text/html");
		 
		 int pid =Integer.parseInt(request.getParameter("pid"));		 
		
		 ManageProduct m = new ManageProduct();
		 Product aProduct =m.getProduct(pid);
		 String output = "<div>Product not found</div>";
				 
		 if (aProduct != null)
		 {
			 output = "<Div> Product name is " + aProduct.getPname() +
					 "<br> Product Price is " + aProduct.getPrice() +
					 "</Div>";
		 }
		 
		 out.println(output);	
		 out.println("<br><a href='menu.html'>Back to Menu</a>");
		 
	}

}

 
