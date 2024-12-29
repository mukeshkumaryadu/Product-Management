import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/updsateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 PrintWriter  out = response.getWriter();
		 response.setContentType("text/html");
		 String output = "<h1>Error in updateing product</h1>";
		 var aId = request.getParameter("pid");
		 if (aId == null)
		 {
			 out.println("Id is null");
			 out.println("<a href='menu.html'>Back to Menu</a>");
			 return;
		 }
		
		 
		 int pid =Integer.parseInt(aId);
		 String pname=request.getParameter("name");
		 int price =Integer.parseInt(request.getParameter("price"));
		 
		 ManageProduct m = new ManageProduct();
		Product oldPd = m.getProduct(pid);
		 if(oldPd==null)
		 { 
			 out.println("Product Not Found");
			 out.println("<a href='menu.html'>Back to Menu</a>");
			 return;
		 }
		 boolean status =m.updateproduct(new Product(pid,pname,price));
		 if(status)
		 {
			 output = "<h1>Product update Successfully</h1>";
		 }	 
		 out.println(output);
		 out.println("<a href='ViewProductServlet.java'>Back to Menu</a>");
		 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int pid = Integer.parseInt(request.getParameter("pid"));
        String htmlContent = "<h1>Update Product</h1>" +
        	    "<form action='updateProduct' method='post'>" +
        	        "<label for='pid'>Product Id:</label>" +
        	        "<input type='number' id='pid' name='pid' value='" + pid + "' required readonly><br><br>" + 
        	        "<label for='name'>Product Name:</label>" +
        	        "<input type='text' id='name' name='name' required><br><br>" +
        	        "<label for='price'>Price:</label>" +
        	        "<input type='number' id='price' name='price' step='0.01' required><br><br>" +
        	        "<button type='submit'>Update Product</button>" +
        	    "</form>" +
        	    "<a href='ViewProductServlet.java'>Back to Menu</a>";
    
        out.println(htmlContent);
	}            
}