public class Product
{
	int pid;
	String pname;
	int price;
	public Product(int pid, String pname, int price) {
		
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	
	public Product( String pname, int price) {
		
		 pid=0;
		this.pname = pname;
		this.price = price;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
}
