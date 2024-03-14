package producerBehavior;

import agents.ProducerAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Booking_Confirmation extends OneShotBehaviour{
	int retour = 0;

	
	ProducerAgent pa;
	public Booking_Confirmation(ProducerAgent pa) {
		this.pa=pa;
		
	}

	@Override
	public void action() {
		System.out.println("booking confirmation");
			pa.doWait();
			System.out.println("booking confirmation");
			MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
	        ACLMessage msg = pa.receive(template);
	        if(msg != null) {
	        	System.out.println("ProducerAgent receiver offer from MarketManager : "+msg.getContent());
	        	ACLMessage reply = msg.createReply();
	        	if (pa.free){
	        		reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
	        		reply.setContent("Booking confirmed");
	        	}
	        	else {
	        		reply.setPerformative(ACLMessage.REJECT_PROPOSAL);
	        		reply.setContent("Booking refused");
	        	}
	        	
	        	pa.send(reply);
                
                
	        }
	        //this.retour = 1;
	}
	
	/*public int doEnd() {
		return 1;
	}*/
	

}
