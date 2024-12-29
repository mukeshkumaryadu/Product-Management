
//package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO 
{

	public ArrayList<Product> getProduct()
	{
		ArrayList<Product> al =new ArrayList<>();		
		try 
		{
			Connection con = GetConnection();
			String query = " select * from product";
			PreparedStatement pmt=con.prepareStatement(query);
			ResultSet rs = pmt.executeQuery();			
			
			while(rs.next())
			{
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3));				
				al.add(p);
			}
			
			return al;
		} 
		 
	 	catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return al;		
	
	}
	
	public boolean addproduct (Product p)
	{
		try {
			Connection con = GetConnection();
			 String query = "INSERT INTO product (id,name,price) VALUES (?, ?, ?)";
			 PreparedStatement pmt=con.prepareStatement(query);
			  pmt.setInt(1, p.getPid()); 
			  pmt.setString(2, p.getPname());
			  pmt.setInt(3, p.getPrice()); 	          
	          return pmt.executeUpdate()>0;
			 
			 
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		  
		 
		return false;
	}
	
	
	public boolean updateproduct(Product p) 
	{
		try {
			Connection con = GetConnection();
			String query = "UPDATE product SET name = ?, price = ? WHERE id = ?";
			 PreparedStatement pmt=con.prepareStatement(query);
			   
			  pmt.setString(1, p.getPname());
			  pmt.setInt(2, p.getPrice()); 	
			  pmt.setInt(3, p.getPid());
	          return pmt.executeUpdate()>0;
			 
			 
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteproduct(int id) 
	{
		try {
			Connection con = GetConnection();
			String query = "DELETE FROM product WHERE id = ?";
			 PreparedStatement pmt=con.prepareStatement(query);
			   
			 pmt.setInt(1, id);
	          return pmt.executeUpdate()>0;
			 
			 
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		
		return false;		
	}
	
	public Product getProduct(int pid) 
	{
		Product p = null;
		try 
		{
			Connection con = GetConnection();
			String query = " select * from product where id = ? ";
			PreparedStatement pmt=con.prepareStatement(query);
			pmt.setInt(1, pid);
			ResultSet rs = pmt.executeQuery();			
		 
			while(rs.next())
			{
				p = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3));				
				break; 
			}
		
			return p;		
		}
		catch (SQLException e) 
		{			 
			e.printStackTrace();
		}
		
		return p;		
	}
	 
	
	
	
	private Connection GetConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/friends","root","!@#$");
		return con;
	}	
	
}
