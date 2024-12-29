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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int pid = Integer.parseInt(request.getParameter("pid"));
        ManageProduct m = new ManageProduct();
		 Product aProduct =m.getProduct(pid);	 
		 
		 if (aProduct == null)
		 {
			 String output = "<h1>Show Product</h1><div>Product not found</div><a href='menu.html'>Back to Menu</a>";
			 out.println(output);
			 return;
		 }
        
        String htmlContent = "<h1>Show Product</h1>" +
            "<form>" +
                "<label for='pid'>Product Id:</label>" +
                "<input type='number' id='pid' name='pid' value='" + aProduct.pid + "' readonly><br><br>" + 
                "<label for='name'>Product Name:</label>" +
                "<input type='text' id='name' name='name' value='" + aProduct.pname + "' readonly><br><br>" +
                "<label for='price'>Price:</label>" +
                "<input type='number' id='price' name='price' value='" + aProduct.price + "' step='0.01' readonly><br><br>" +      
            "</form>" +
            "<a href='menu.html'>Back to Menu</a>";               
        out.println(htmlContent);
	}

}

 
