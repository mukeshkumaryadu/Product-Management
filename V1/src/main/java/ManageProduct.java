import java.util.ArrayList;

public class ManageProduct 
{
	private static ArrayList<Product> al= new ArrayList<>();
	private static int pid=1;		
	
    public ArrayList<Product> getProduct()
    {
	     return al;     
    }   
	 	 		
	public boolean addproduct(Product p)
	{
		p.pid=pid++;
		al.add(p);
		return true;		
	}
	
	public boolean updateproduct(Product p)
	{
		for(Product p1 : al)
		{
			if(p.pid==p1.getPid())
			{
				p1.setPname(p.pname); 
				p1.setPrice(p.price);
				return true;
			}				
		}		
		
		return false;		
	}	

	public boolean deleteproduct(int pid) {
		for(Product p1 : al)
		{
			if(pid==p1.getPid())
			{
				al.remove(pid-1);
				return true;
			}
			
		}
		
		return false;
	}


	public Product getProduct(int pid) {
		 for(Product p1 : al) 
		 {
			 if(pid==p1.getPid())
					 {
				 return p1;
				 
					 }
		 }
		return null;
	}
}