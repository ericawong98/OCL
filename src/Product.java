
public class Product {
	public String sku;
	private String name;
	private double price;
	
	public Product(String sku, String name, double d) {
		this.sku=sku;
		this.name=name;
		this.price=d;
	}
	
	public String getsku() {
		return this.sku;
	}
	
	public String getname() {
		return this.name;
	}
	
	public double getprice() {
		return this.price;
	}
}
