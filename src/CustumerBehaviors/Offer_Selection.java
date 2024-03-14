package CustumerBehaviors;

import agents.ConsumerAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import offers.Offers;

public class Offer_Selection extends OneShotBehaviour {
	ConsumerAgent ca;
	
	public Offer_Selection(ConsumerAgent ca) {
		super(ca);
		this.ca = ca;
		
	}

	@Override
	public void action() {
		//while(true) {
			this.ca.doWait();
			/*MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
	        ACLMessage msg = ca.receive(template);
	        if(msg != null) {
	        	System.out.println(msg);
	        	System.out.println(msg.getSender().getName());
	        	System.out.println("ConsumerAgent receiver offer from MarketPlaceAgent  : "+msg.getContent());
	        	
	        	//ACLMessage reply = msg.createReply();
	            //reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
	            //reply.setContent("Booking confirmed");
	        }*/
	        //else {
	        	//block();
	        //}
		//}
		
		MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage message = ca.receive(mt);
        System.out.println("offer reveived from MarketManager"+message);

        if (message != null) {
            // Supposons que le message contient l'offre sous forme de chaîne sérialisée
            String content = message.getContent();
            
            // Convertir la chaîne en un objet Offers (cette partie dépend de votre implémentation)
            Offers offer = parseOfferFromString(content);
            
            if(offer != null) {
                ca.addOffer(offer);
            }
        } else {
            block();
        }
    }

    
private Offers parseOfferFromString(String offerStr) {
	System.out.println("ajout des offres reçues"+offerStr);
    // Implémentez cette méthode pour convertir la chaîne reçue en un objet Offers
    // Cela pourrait impliquer de séparer la chaîne par des virgules et de créer un nouvel objet Offers avec les données extraites
    // Exemple très basique et fictif :
    // String[] parts = offerStr.split(",");
    // return new Offers(Double.parseDouble(parts[0]), Integer.parseInt(parts[1]), Boolean.parseBoolean(parts[2]), parts[3]);
	String[] d = offerStr.split(", ");
	System.out.println(d[0]);
	System.out.println(d[1]);
	System.out.println(d[2]);
	System.out.println(d[3]);
	
	double selling_price = Double.parseDouble(d[0].split("=")[1]);
	int quantity = Integer.parseInt(d[2].split("=")[1]);
	Boolean renewable = Boolean.parseBoolean(d[1].split("=")[1]);
	String sender= d[3].split("=")[1];
	Offers offer = new Offers(selling_price,quantity,renewable,sender);
    return offer; // Retournez l'objet Offers correctement construit
    
}

}
