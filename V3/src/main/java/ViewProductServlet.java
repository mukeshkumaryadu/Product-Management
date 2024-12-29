import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		ManageProduct mp = new ManageProduct();		
		ArrayList<Product> al =mp.getProduct();		
		PrintWriter  out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2><a href='addProduct'>Add</a></h2>");
		out.println("<h1>Product List</h1>");
		 
		String contextPath = request.getContextPath();
		String htmlContent = "<div style='display: flex; flex-wrap: wrap; gap: 20px; padding: 10px;'>";

		for (Product p : al) {
		    htmlContent += "<div style='border: 1px solid #ddd; border-radius: 8px; padding: 16px; width: 250px; text-align: center;'>" +
		        "<h3 style='margin: 0 0 10px;'>Name: " + p.getPname() + "</h3>" +
		        "<p style='margin: 5px 0; color: #555;'>Price: " + p.getPrice() + "/-</p>" +
		        "<div>" +
		            "<a href='" + contextPath + "/updateProduct?pid=" + p.getPid() + "' style='margin: 5px; color: white; background: #007BFF; padding: 5px 10px; text-decoration: none; border-radius: 4px;'>Update</a>" +
		            "<a href='" + contextPath + "/deleteProduct?pid=" + p.getPid() + "' style='margin: 5px; color: white; background: #DC3545; padding: 5px 10px; text-decoration: none; border-radius: 4px;'>Delete</a>" +
		            "<a href='" + contextPath + "/ShowProduct?pid=" + p.getPid() + "' style='margin: 5px; color: white; background: #28A745; padding: 5px 10px; text-decoration: none; border-radius: 4px;'>View</a>" +
		        "</div>" +
		    "</div>";
		}
		htmlContent += "</div>";
		out.println(htmlContent);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManageProduct mp = new ManageProduct();		
		ArrayList<Product> al =mp.getProduct();		
		PrintWriter  out = response.getWriter();
		response.setContentType("text/html");		 
		out.println("<h1>Product List</h1>");
		 
		for(Product p : al)
		{
			out.println("<li>ID: " + p.getPid() +
		            ", Name: " + p.getPname() +
		            ", Price: " + p.getPrice() + 
		            " <a href='updateProduct?pid=" + p.getPid() + "'>Update</a>"
		            + " \" <a href='deleteProduct?pid=" + p.getPid() + "'>Delete</a>"
		            + " \" <a href='ShowProduct?pid=" + p.getPid() + "'>View</a>"
		            + "</li>"+ " \" <a href='addProduct'>Add</a>");	
		}
				   
		out.println("<a href='ViewProductServlet.java'>Back to Menu</a>");		
	}

}
