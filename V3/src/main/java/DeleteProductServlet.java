//package com.cdac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
//@WebServlet("/deleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter  out = response.getWriter();
		response.setContentType("text/html");
		String output = "<h1>Error in deleteing product</h1>";
		int pid =Integer.parseInt(request.getParameter("pid"));
		 
		 ManageProduct m = new ManageProduct();
		 boolean status =m.deleteproduct(pid);
		 if(status)
		 {
			 output = "<h1>Product delete Successfully</h1>";			 
		 }
		 
		 out.println(output);
		 out.println("<a href='menu.html'>Back to Menu</a>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int pid = Integer.parseInt(request.getParameter("pid"));
        String htmlContent = "<h1>Delete Product</h1>" +
        	    "<form action='deleteProduct' method='post'>" +
        	        "<label for='pid'>Product Id:</label>" +
        	        "<input type='number' id='pid' name='pid' value='" + pid + "' required readonly><br><br>" +
        	        "<button type='submit'>Delete Product</button>" +
        	    "</form>" +
        	    "<a href='menu.html'>Back to Menu</a>";

        
        
        out.println(htmlContent);
	}            
}