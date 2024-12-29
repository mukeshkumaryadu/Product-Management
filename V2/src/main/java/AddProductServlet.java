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

}
