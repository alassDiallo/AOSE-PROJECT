package agents;

import java.util.ArrayList;
import java.util.List;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import market_manager.Booking_Arbitration;
import market_manager.Offer_Management;
import market_manager.Send_booking_confirmation;
import market_manager.Update_offers;
import offers.Offers;
import producerBehavior.Booking_Confirmation;
import producerBehavior.Determining_energy_pricing;
import producerBehavior.Energy_Advertisement;

public class MarketplaceAgent extends Agent {
	
	
	private static final String BEHAVIOUR_DEBUT="debut";
	private static final String BEHAVIOUR_BOOKINGARBITRA="bookingArbitration";
	private static final String BEHAVIOR_OFFERMANAGEMENT="offerManagement";
	private static final String BEHAVIOR_SENDBOOKCONF="sendBookingConf";
	private static final String BEHAVIOR_UPDATEOFFERS="updateOffers";
	private static final String BEHAVIOUR_FIN="fin";
	List<Offers> offers = new ArrayList<>();
	
	public static AID IDENTIFIANT = new AID("MarketplaceAgent", AID.ISLOCALNAME);
	
    protected void setup() {
    	FSMBehaviour behaviour = new FSMBehaviour(this);
    	behaviour.registerFirstState(new Update_offers(this),BEHAVIOR_UPDATEOFFERS);
		behaviour.registerState(new Offer_Management(this), BEHAVIOR_OFFERMANAGEMENT);
		//behaviour.registerState(new SearchPlace(this), BEHAVIOR_SEARCH);
		behaviour.registerState(new Send_booking_confirmation(this), BEHAVIOR_SENDBOOKCONF);
		behaviour.registerLastState(new Booking_Arbitration(this), BEHAVIOUR_BOOKINGARBITRA);
		//behaviour.registerTransition(BEHAVIOR_GETREQUEST,BEHAVIOR_GETREQUEST,0);
		//behaviour.registerTransition(BEHAVIOR_GETREQUEST,BEHAVIOUR_INITIALISATION,1);
		//behaviour.registerDefaultTransition(BEHAVIOUR_DEBUT,BEHAVIOR_UPDATEOFFERS);
		behaviour.registerDefaultTransition(BEHAVIOR_UPDATEOFFERS,BEHAVIOR_OFFERMANAGEMENT);
		behaviour.registerDefaultTransition(BEHAVIOR_OFFERMANAGEMENT,BEHAVIOR_SENDBOOKCONF);
		behaviour.registerDefaultTransition(BEHAVIOR_SENDBOOKCONF,BEHAVIOUR_BOOKINGARBITRA);
		addBehaviour(behaviour);
    }
    
    public void addOffers(String sender,String data) {
    	String[] d = data.split(",");
    	double selling_price = Double.parseDouble(d[0].split("=")[1]);
    	int quantity = Integer.parseInt(d[1].split("=")[1]);
    	Boolean renewable = Boolean.parseBoolean(d[2].split("=")[1]);
    	this.offers.add(new Offers(selling_price,quantity,renewable,sender));
    	for (Offers off : offers) {
    		System.out.println(off);
    	}
    	System.out.println("add offers");
    	
    }
    

    public String convertirListeEnString() {
		//String resultat = convertirListeEnString(listeObjets);
	
	    // Affichage du résultat
	    StringBuilder sb = new StringBuilder();
	    for (Offers objet : this.offers) {
	        sb.append(objet.toString()); // Ajouter la représentation textuelle de l'objet à la chaîne
	        sb.append("; "); // Ajouter une virgule pour séparer les éléments (optionnel)
	    }
	    // Supprimer la dernière virgule et l'espace après le dernier élément (si nécessaire)
	    if (sb.length() > 0) {
	        sb.delete(sb.length() - 2, sb.length());
	    }
	    return sb.toString();
	}
    

  
}