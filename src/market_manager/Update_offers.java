package market_manager;

import agents.MarketplaceAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Update_offers extends OneShotBehaviour {
	MarketplaceAgent mpa;
	public Update_offers(MarketplaceAgent mpa) {
		this.mpa = mpa;
		
	}
	@Override
	public void action() {
		while (true){
		this.mpa.doWait();
		MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage msg = mpa.receive(template);
        if(msg != null) {
        	System.out.println(msg);
        	System.out.println(msg.getSender().getName());
        	System.out.println("MarketManager receiver offer from Producer  : "+msg.getContent());
        	this.mpa.addOffers(msg.getSender().getName(),msg.getContent());
        	//ACLMessage reply = msg.createReply();
            //reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
            //reply.setContent("Booking confirmed");
        }
        else {
        	block();
        }
	}
	}
	
	

}
