import java.util.ArrayList;

public class ManageProduct 
{
	ProductDAO myDataBase = new ProductDAO();
	//ProductDAOArrayList myDataBase = new ProductDAOArrayList();
    public ArrayList<Product> getProduct()
    {
		return myDataBase.getProduct();   
    }   
	 	 		
	public boolean addproduct(Product p)
	{		
		p.pid=GetId();		
		return myDataBase.addproduct(p);		
	}
	
	public boolean updateproduct(Product p)
	{	
		return myDataBase.updateproduct(p);		
	}	

	public boolean deleteproduct(int pid) 
	{		
		return myDataBase.deleteproduct(pid);
	}


	public Product getProduct(int pid) {
		 
		return myDataBase.getProduct(pid);
	}
	
	public int GetId()
	{
		ArrayList<Product> aProducts = this.getProduct();
		Product aProduct = aProducts.get(aProducts.size()-1);
		return aProduct.pid+1;
	}
}