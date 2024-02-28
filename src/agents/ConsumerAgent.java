package agents;

import java.util.Map;
import java.util.Set;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ConsumerAgent extends Agent {
	
	private static final String BEHAVIOUR_DEBUT="debut";
	private static final String BEHAVIOUR_SELECTIONOFFER="selectionOffer";
	private static final String BEHAVIOR_REQUESTENERGY="requestEnergy";
	private static final String BEHAVIOR_ENERGYBOOKING="energyBooking";
	private static final String BEHAVIOR_EVALUATEOFFER="evaluateOffer";
	private static final String BEHAVIOUR_FIN="fin";
	//private Map<String,String> pref;
	//private Places[] places;
	//private Set<Places> placesfound;
	
	public static AID IDENTIFIANT = new AID("ConsumerAgent", AID.ISLOCALNAME);
	
    protected void setup() {
    	FSMBehaviour behaviour = new FSMBehaviour(this);
    	/*behaviour.registerFirstState(new GetRequestUser(this), BEHAVIOR_GETREQUEST);
		behaviour.registerState(new InitialiseData(this), BEHAVIOUR_INITIALISATION);
		behaviour.registerState(new SearchPlace(this), BEHAVIOR_SEARCH);
		behaviour.registerLastState(new RespondAgent(this), BEHAVIOR_RESPOND);
		behaviour.registerTransition(BEHAVIOR_GETREQUEST,BEHAVIOR_GETREQUEST,0);
		behaviour.registerTransition(BEHAVIOR_GETREQUEST,BEHAVIOUR_INITIALISATION,1);
		behaviour.registerDefaultTransition(BEHAVIOUR_INITIALISATION,BEHAVIOR_SEARCH);
		behaviour.registerDefaultTransition(BEHAVIOR_SEARCH,BEHAVIOR_RESPOND);
		addBehaviour(behaviour);*/
    }

    private class RequestEnergyBehaviour extends CyclicBehaviour {
        public void action() {
            ACLMessage msg = new ACLMessage(ACLMessage.CFP);
            msg.setContent("Requesting energy");
            msg.addReceiver(getAID("MarketplaceAgent"));
            send(msg);

            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);
            ACLMessage reply = receive(mt);
            if (reply != null) {
            	System.out.println(reply);
                // Evaluate offers and book energy consumption
            } else {
                block();
            }
        }
    }
}
