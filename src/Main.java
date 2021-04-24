import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		Main gui = new Main();
		gui.go();
	}
	
	public void go() {
		Discount pricingRules = new Discount();
		Checkout co = new Checkout(pricingRules);
		
		System.out.print("SKUs Scanned: ");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = "";
		try { inputLine = input.readLine(); } 
		catch (IOException e) {
	        System.out.print("Input Error!");
	        e.printStackTrace();
	      }
		String[] myitem = inputLine.split(", ");
		
		for(String item:myitem) { co.scan(item); }
		System.out.println(co.total());
	}

}
