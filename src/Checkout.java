import java.util.HashMap;

public class Checkout {
	HashMap <String, Integer> cart = new HashMap <String, Integer>();
	Discount rules;
	
	//constructor of Checkout 
	public Checkout(Discount rules) { this.rules = rules; };
	
	/*when a product is scanned, this is added into the shopping cart. 
	 * if the item already exists in the cart, the amount is incremented.
	 */
	public void scan(String sku) {
		if(this.cart.containsKey(sku)) { this.cart.put(sku, this.cart.get(sku)+1); }
		else { this.cart.put(sku, 1); }	
	}
	
	/* calls the Discount object to calculate the total amount and returns
	 * a formatted value in a string.
	 */
	public String total() {
		return String.format("Total Expected: $%.2f",rules.getTotal(cart));
	}
}
