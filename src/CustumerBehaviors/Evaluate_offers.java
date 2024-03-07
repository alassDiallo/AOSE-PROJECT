package CustumerBehaviors;

import agents.ConsumerAgent;
import jade.core.behaviours.OneShotBehaviour;

public class Evaluate_offers extends OneShotBehaviour{
	ConsumerAgent ca;
	
	public Evaluate_offers(ConsumerAgent ca) {
		this.ca = ca;
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
		System.out.println("evaluate offers");
		
	}
	
}
