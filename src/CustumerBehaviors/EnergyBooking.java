package CustumerBehaviors;

import agents.ConsumerAgent;
import jade.core.behaviours.OneShotBehaviour;

public class EnergyBooking extends OneShotBehaviour {
	
	ConsumerAgent ca;
	
	public EnergyBooking(ConsumerAgent ca) {
		this.ca =ca;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("energy booking");
		
	}

}
