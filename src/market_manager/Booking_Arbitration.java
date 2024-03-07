package market_manager;

import agents.MarketplaceAgent;
import jade.core.behaviours.OneShotBehaviour;

public class Booking_Arbitration extends OneShotBehaviour {
	MarketplaceAgent mpa;
	
	public Booking_Arbitration(MarketplaceAgent mpa) {
		this.mpa = mpa;
		
	}

	@Override
	public void action() {
		System.out.println("booking arbitrairarie");
		
	}
	
	public int onEnd() {
		return 1;
	}
	
	

}
