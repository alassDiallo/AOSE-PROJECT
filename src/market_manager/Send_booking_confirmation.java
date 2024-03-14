package market_manager;

import agents.MarketplaceAgent;
import agents.ProducerAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import offers.Offers;

public class Send_booking_confirmation extends OneShotBehaviour {
	MarketplaceAgent mpa;
	
	public Send_booking_confirmation(MarketplaceAgent mpa) {
		this.mpa = mpa;
		
	}

	@Override
	public void action() {
		//String content = pa.toString();
		mpa.doWait();
		System.out.println("send booking");
		MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage message = mpa.receive(mt);
        if (message != null) {
        System.out.println(message);
        System.out.println("send the booking energy to Producer");
    	ACLMessage m = new ACLMessage(ACLMessage.REQUEST);
		m.setContent(message.getContent());
		
		m.addReceiver(ProducerAgent.IDENTIFIANT);
		mpa.send(m);
		ProducerAgent p = new ProducerAgent();
		if (p.free) {
			System.out.println("booking success");
			p.free = false;
		}
		else {
			System.out.println("Sorry booking failed");
		}
        }
		
	}

}
