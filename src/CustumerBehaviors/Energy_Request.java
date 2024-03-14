package CustumerBehaviors;

import agents.ConsumerAgent;
import agents.MarketplaceAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Energy_Request extends OneShotBehaviour {
	
	ConsumerAgent ca;
	public Energy_Request(ConsumerAgent ca) {
		this.ca = ca;
	}
	@Override
	public void action() {
		//String content = ca.toString();
		ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
		message.setContent("can u please share me the list of available energy");
		message.addReceiver(MarketplaceAgent.IDENTIFIANT);
		ca.send(message);
	}
	
	

}
