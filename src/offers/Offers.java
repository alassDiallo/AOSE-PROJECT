package offers;

public class Offers {
	double price;
	boolean renewable;
	int quantity;
	String agentID;
	
	public Offers(double price,int quantity, boolean type,String agent) {
		this.price = price;
		this.renewable = type;
		this.quantity=quantity;
		this.agentID = agent; 
	}

	@Override
	public String toString() {
		return "Offers [price=" + price + ", renewable=" + renewable + ", quantity=" + quantity + ", agentID=" + agentID + "]";
	}
	
	
}
