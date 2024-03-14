package agents;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import CustumerBehaviors.EnergyBooking;
import CustumerBehaviors.Energy_Request;
import CustumerBehaviors.Evaluate_offers;
import CustumerBehaviors.Offer_Selection;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import offers.Offers;

public class ConsumerAgent extends Agent {
	
	private static final String BEHAVIOUR_DEBUT="debut";
	private static final String BEHAVIOUR_SELECTIONOFFER="selectionOffer";
	private static final String BEHAVIOR_REQUESTENERGY="requestEnergy";
	private static final String BEHAVIOR_ENERGYBOOKING="energyBooking";
	private static final String BEHAVIOR_EVALUATEOFFER="evaluateOffer";
	private static final String BEHAVIOUR_FIN="fin";
	List<Offers> offers = new ArrayList<>();
	public static AID IDENTIFIANT = new AID("ConsumerAgent", AID.ISLOCALNAME);
	
    protected void setup() {
    	FSMBehaviour behaviour = new FSMBehaviour(this);
    	behaviour.registerFirstState(new Energy_Request(this), BEHAVIOR_REQUESTENERGY);
		behaviour.registerState(new Offer_Selection(this), BEHAVIOUR_SELECTIONOFFER);
		behaviour.registerState(new Evaluate_offers(this), BEHAVIOR_EVALUATEOFFER);
		behaviour.registerLastState(new EnergyBooking(this), BEHAVIOR_ENERGYBOOKING);
		//behaviour.registerTransition(BEHAVIOR_GETREQUEST,BEHAVIOR_GETREQUEST,0);
		//behaviour.registerTransition(BEHAVIOR_GETREQUEST,BEHAVIOUR_INITIALISATION,1);
		behaviour.registerDefaultTransition(BEHAVIOR_REQUESTENERGY,BEHAVIOUR_SELECTIONOFFER);
		behaviour.registerDefaultTransition(BEHAVIOUR_SELECTIONOFFER,BEHAVIOR_EVALUATEOFFER);
		behaviour.registerDefaultTransition(BEHAVIOR_EVALUATEOFFER,BEHAVIOR_ENERGYBOOKING);
		addBehaviour(behaviour);
    }
    
    /*public List<Offers> getReceivedOffers() {
    	return this.offers ;
    	
    }*/
    public List<Offers> getReceivedOffers() {
        return new ArrayList<>(this.offers); // Retourne une copie pour éviter la modification extérieure
    }

    public void addOffer(Offers offer) {
    	System.out.println("ajout de l'offre "+offer);
        this.offers.add(offer);
    }

   
    
}
