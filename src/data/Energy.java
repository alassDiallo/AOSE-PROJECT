package data;

public class Energy {
	
	public double selling_price;
	public int quantity;
	public boolean renewable;
	
	public Energy(double d,int quantity, boolean renewable) {
			this.selling_price=d;
			this.quantity= quantity;
			this.renewable= renewable;
		
	}

}
