package market_manager;

import agents.MarketplaceAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Booking_Arbitration extends OneShotBehaviour {
	MarketplaceAgent mpa;
	
	public Booking_Arbitration(MarketplaceAgent mpa) {
		this.mpa = mpa;
		
	}

	@Override
	public void action() {
		mpa.doWait();
		MessageTemplate ma = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
		MessageTemplate mr = MessageTemplate.MatchPerformative(ACLMessage.REJECT_PROPOSAL);
        ACLMessage messa = mpa.receive(ma);
        ACLMessage messr = mpa.receive(mr);
        if( messa != null) {
        	System.out.println(messa);
        	System.out.println("accepter");
        }
        if (messr != null) {
        	 System.out.println(messr);
     		System.out.println("booking arbitrairarie");
        }
       
       
		
	}
	
	

}
