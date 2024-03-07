package CustumerBehaviors;

import agents.ConsumerAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Offer_Selection extends OneShotBehaviour {
	ConsumerAgent ca;
	
	public Offer_Selection(ConsumerAgent ca) {
		this.ca = ca;
		
	}

	@Override
	public void action() {
		while(true) {
			this.ca.doWait();
			MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
	        ACLMessage msg = ca.receive(template);
	        if(msg != null) {
	        	System.out.println(msg);
	        	System.out.println(msg.getSender().getName());
	        	System.out.println("ConsumerAgent receiver offer from MarketPlaceAgent  : "+msg.getContent());
	        	
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
