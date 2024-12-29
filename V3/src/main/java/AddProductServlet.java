import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter  out = response.getWriter();
		response.setContentType("text/html");
		String output = "<h1>Error in adding product</h1>";
		 String pname=request.getParameter("name");
		 int price =Integer.parseInt(request.getParameter("price"));
		 
		 ManageProduct m = new ManageProduct();
		 boolean status =m.addproduct(new Product(pname,price));
		 if(status)
		 { 
			 output = "<h1>Product Added Successfully</h1>";
		 }
		 
		 out.println(output);
		 out.println("<a href='menu.html'>Back to Menu</a>");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	 String   m1 = "<h1>Product Ready to Add Successfully</h1>";
	 out.println(m1);
	    // Generate the HTML form for adding a product
	    String htmlContent = "<h1>Add Product</h1>" +
	        "<form action='addProduct' method='post'>" +
	            "<label for='pid'>Product Id:</label>" +
	            "<input type='number' id='pid' name='pid' required><br><br>" + // User will input Product ID
	            "<label for='name'>Product Name:</label>" +
	            "<input type='text' id='name' name='name' required><br><br>" + // User will input Product Name
	            "<label for='price'>Price:</label>" +
	            "<input type='number' id='price' name='price' step='0.01' required><br><br>" + // User will input Price
	            "<button type='submit'>Add Product</button>" +
	        "</form>" +
	        "<a href='ViewProductServlet'>Back to Menu</a>"; // Link back to menu or product view page

	    out.println(htmlContent);
	}

}
