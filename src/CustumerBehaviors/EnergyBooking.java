package CustumerBehaviors;

import agents.ConsumerAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class EnergyBooking extends OneShotBehaviour {
	
	ConsumerAgent ca;
	
	public EnergyBooking(ConsumerAgent ca) {
		this.ca =ca;
	}

	@Override
	public void action() {
		ca.doWait();
		MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage message = ca.receive(mt);
        System.out.println(message);
		System.out.println("energy booking");
		
	}

}
