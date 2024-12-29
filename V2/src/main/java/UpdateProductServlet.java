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
		 int pid =Integer.parseInt(request.getParameter("pid"));
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
		 out.println("<a href='menu.html'>Back to Menu</a>");
		 
	}
}