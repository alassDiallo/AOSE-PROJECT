package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class MarketplaceAgent extends Agent {
	
	
	private static final String BEHAVIOUR_DEBUT="debut";
	private static final String BEHAVIOUR_BOOKINGARBITRA="bookingArbitration";
	private static final String BEHAVIOR_OFFERMANAGEMENT="offerManagement";
	private static final String BEHAVIOR_SENDBOOKCONF="sendBookingConf";
	private static final String BEHAVIOR_UPDATEOFFERS="updateOffers";
	private static final String BEHAVIOUR_FIN="fin";
	
	public static AID IDENTIFIANT = new AID("MarketplaceAgent", AID.ISLOCALNAME);
	
    protected void setup() {
        addBehaviour(new HandleRequestsBehaviour());
    }

    private class HandleRequestsBehaviour extends CyclicBehaviour {
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = receive(mt);
            if (msg != null) {
            	System.out.println(msg);
                // Handle consumer requests and provide energy offers
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.PROPOSE);
                reply.setContent("Energy offer");
                send(reply);
            } else {
                block();
            }
        }
    }
}