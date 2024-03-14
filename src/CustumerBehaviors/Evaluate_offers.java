package CustumerBehaviors;

import java.util.Comparator;
import java.util.List;

import agents.ConsumerAgent;
import agents.MarketplaceAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import offers.Offers;

public class Evaluate_offers extends OneShotBehaviour{
	ConsumerAgent ca;
	
	public Evaluate_offers(ConsumerAgent ca) {
		this.ca = ca;
		
	}

	@Override
	public void action() {
		List<Offers> offers = this.ca.getReceivedOffers(); // Supposons que cette méthode existe et récupère les offres
        if (offers.isEmpty()) {
            System.out.println("Aucune offre reçue.");
            return;
        }

        // Trier les offres: d'abord par énergie renouvelable, puis par prix croissant
        offers.sort(Comparator.comparing(Offers::isRenewable).reversed()
                                .thenComparing(Offers::getPrice));

        // Supposons que l'agent choisit la première offre après le tri comme la meilleure
        Offers bestOffer = offers.get(0);
        System.out.println("Meilleure offre sélectionnée: " + bestOffer);
		ACLMessage message = new ACLMessage(ACLMessage.INFORM);
		message.setContent(bestOffer.toString());
		message.addReceiver(MarketplaceAgent.IDENTIFIANT);
		ca.send(message);
        // Ici, vous pourriez ajouter la logique pour que l'agent réponde au marché ou prenne des actions basées sur cette meilleure offre
    }
		
	
	
}
