package producerBehavior;

import agents.ProducerAgent;
import agents.MarketplaceAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Energy_Advertisement extends OneShotBehaviour {
	ProducerAgent pa;
	
	public Energy_Advertisement(ProducerAgent pa) {
		this.pa = pa;
		
	}

	@Override
	public void action() {
		String content = pa.toString();
		ACLMessage message = new ACLMessage(ACLMessage.INFORM);
		message.setContent(content);
		message.addReceiver(MarketplaceAgent.IDENTIFIANT);
		pa.send(message);
	}

}
