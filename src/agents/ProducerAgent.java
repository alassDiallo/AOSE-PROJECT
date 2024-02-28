package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ProducerAgent extends Agent {
	
	private static final String BEHAVIOUR_DEBUT="debut";
	private static final String BEHAVIOUR_BOOKINGCONFIRMATION="bookingConf";
	private static final String BEHAVIOR_DETERMINIGENERGIE="determiningEnergy";
	private static final String BEHAVIOR_ENERGYADVERTISSEMENT="energyAdvertissement";
	private static final String BEHAVIOUR_FIN="fin";
	
	public static AID IDENTIFIANT = new AID("ProducerAgent", AID.ISLOCALNAME);
	
    protected void setup() {
        addBehaviour(new HandleRequestsBehaviour());
    }

    private class HandleRequestsBehaviour extends CyclicBehaviour {
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = receive(mt);
            if (msg != null) {
                // Handle booking requests from consumers
            	System.out.println(msg);
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                reply.setContent("Booking confirmed");
                send(reply);
            } else {
                block();
            }
        }
    }
}

