package producerBehavior;

import java.util.Random;

import agents.ProducerAgent;
import jade.core.behaviours.OneShotBehaviour;

public class Determining_energy_pricing extends OneShotBehaviour {
	ProducerAgent pa;
	
	public Determining_energy_pricing(ProducerAgent pa) {
		this.pa = pa;
	}

	@Override
	public void action() {
		
		this.pa.Initialisation();
	}

}
