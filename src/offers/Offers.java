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

	
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isRenewable() {
		return renewable;
	}


	public void setRenewable(boolean renewable) {
		this.renewable = renewable;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getAgentID() {
		return agentID;
	}


	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}


	@Override
	public String toString() {
		return "price=" + price + ", renewable=" + renewable + ", quantity=" + quantity + ", agentID=" + agentID;
	}
	
	
}
