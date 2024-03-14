package market_manager;

import agents.ConsumerAgent;
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
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
		
        if( messa != null) {
        	System.out.println(messa);
        	message.setContent("Booking success");
        	System.out.println("Booking success");
        }
        if (messr != null) {
        	 System.out.println(messr);
        	 message.setContent("Booking fail");
     		System.out.println("booking fail");
        }
        
        message.addReceiver(ConsumerAgent.IDENTIFIANT);
		mpa.send(message);
       
       
		
	}
	
	

}
