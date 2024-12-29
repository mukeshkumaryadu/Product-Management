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
		out.println("<h1>Product List</h1>");
		 
		for(Product p : al)
		{
			out.println("<li>ID: " + p.getPid() +
                    ", Name: " + p.getPname() +
                    ", Price: " + p.getPrice() + "</li>");			
		}
				   
		out.println("<a href='menu.html'>Back to Menu</a>");
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
