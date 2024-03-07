package market_manager;

import agents.MarketplaceAgent;
import agents.ProducerAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Send_booking_confirmation extends OneShotBehaviour {
	MarketplaceAgent mpa;
	
	public Send_booking_confirmation(MarketplaceAgent mpa) {
		this.mpa = mpa;
		
	}

	@Override
	public void action() {
		//String content = pa.toString();
		ACLMessage message = new ACLMessage(ACLMessage.INFORM);
		message.setContent("envoi de la reservation");
		message.addReceiver(ProducerAgent.IDENTIFIANT);
		mpa.send(message);
		
	}

}
