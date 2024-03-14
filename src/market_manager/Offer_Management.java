package market_manager;

import agents.MarketplaceAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Offer_Management extends OneShotBehaviour {
	MarketplaceAgent mpa;

	public Offer_Management(MarketplaceAgent mpa) {
		this.mpa = mpa;
		
	}
	@Override
	public void action() {
		//while(true) {
		System.out.println("offer manager");
		mpa.doWait();
		MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        ACLMessage msg = mpa.receive(template);
        System.out.println(msg);
        if(msg != null) {
        	System.out.println(msg);
        	System.out.println("MarketManager receiver offer from Consumer  : "+msg.getContent());
        	ACLMessage reply = msg.createReply();
            //reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
            //reply.setContent("Booking confirmed");
        	String content = mpa.convertirListeEnString();
        	System.out.println("----------------------------------");
        	System.out.println(content);
        	System.out.println("----------------------------------");
        	reply.setPerformative(ACLMessage.INFORM);
            reply.setContent(content);
            mpa.send(reply);
        }
        //else {
        	//block();
        //}
		
	//}
	}

}
