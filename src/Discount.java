import java.util.HashMap;

public class Discount {
	HashMap <String, Product> catalog = new HashMap <String, Product>();
	
	/*creates the Product List that contains its sku as an identifier.
	 * and the product object as the return value. 
	 */
	public Discount(){ initProductList(); }
	
	/*
	 * When the shopping cart list needs to be summed, this method first 
	 * checks if the items in it are eligible for discount. After handling
	 * the discounted items, it goes through the remaining items and calculates
	 * the amount based its price in the product list and the amount of the 
	 * product in the shopping cart. 
	 */
	public double getTotal(HashMap <String, Integer> cart) {
		double total=0;
		total+=checkDiscount(cart);
		for (String sku:cart.keySet()) {
			total+=catalog.get(sku).getprice()*cart.get(sku);
		}
		return total;
	}
	
	/*
	 * To check if there are items in the cart eligible for discount,
	 * this method checks if the promotional items exist in the shopping
	 * cart and if it meets the discount criteria. If it does, then the
	 * discount prices are applied to the bill and it is removed from 
	 * the shopping cart to avoid double billing. 
	 * 
	 * If there are new discounts, the manager can just set the rules here.
	 * If discounts need to be removed, the if-statement can just be deleted.
	 */
	private double checkDiscount(HashMap <String, Integer> cart) {
		double mysum=0;
		//3 for 2 deal on Apple TVs
		if(cart.containsKey("atv") && cart.get("atv").equals(3)) {
			mysum+=catalog.get("atv").getprice()*2;
			cart.remove("atv");
		}
		//Bulk discount for Super iPad
		if(cart.containsKey("ipd") && cart.get("ipd")>=4) {
			mysum+=499.99*cart.get("ipd");
			cart.remove("ipd");
		}
		//Free VGA for every MacBook Pro
		if(cart.containsKey("mbp") && cart.containsKey("vga")) {
			int free = cart.get("mbp");
			if(cart.get("vga")>free) { mysum+=catalog.get("vga").getprice()*(cart.get("vga")-free);}
			cart.remove("vga");
			}
		return mysum;
	}
	
	/*
	 * Constructs the product catalog that can retrieve product details
	 * using its sku. 
	 */
	private void initProductList() {
		addToCatalog(new Product ("ipd", "Super Ipad", 549.99));
		addToCatalog(new Product ("mbp", "MacBook Pro", 1399.99));
		addToCatalog(new Product ("atv", "Apple TV", 109.5));
		addToCatalog(new Product ("vga", "VGA adapter", 30.00));
	}
	
	private void addToCatalog(Product myproduct) {
		this.catalog.put(myproduct.sku, myproduct);
	}
}
