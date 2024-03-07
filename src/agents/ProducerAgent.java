package agents;

import java.text.DecimalFormat;
import java.util.Random;
import data.Energy;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import producerBehavior.Booking_Confirmation;
import producerBehavior.Determining_energy_pricing;
import producerBehavior.Energy_Advertisement;

public class ProducerAgent extends Agent {
	
	public double selling_price;
	public int quantity;
	public boolean renewable;
	private static final String BEHAVIOUR_DEBUT="debut";
	private static final String BEHAVIOUR_BOOKINGCONFIRMATION="bookingConf";
	private static final String BEHAVIOR_DETERMINIGENERGIE="determiningEnergy";
	private static final String BEHAVIOR_ENERGYADVERTISSEMENT="energyAdvertissement";
	private static final String BEHAVIOUR_FIN="fin";
	
	public static AID IDENTIFIANT = new AID("ProducerAgent", AID.ISLOCALNAME);
	
	
    protected void setup() {
    	
    	FSMBehaviour behaviour = new FSMBehaviour(this);
    	behaviour.registerFirstState(new Determining_energy_pricing(this),BEHAVIOUR_DEBUT);
		behaviour.registerState(new Energy_Advertisement(this), BEHAVIOR_ENERGYADVERTISSEMENT);
		//behaviour.registerState(new SearchPlace(this), BEHAVIOR_SEARCH);
		behaviour.registerLastState(new Booking_Confirmation(this), BEHAVIOUR_BOOKINGCONFIRMATION);
		//behaviour.registerTransition(BEHAVIOR_GETREQUEST,BEHAVIOR_GETREQUEST,0);
		//behaviour.registerTransition(BEHAVIOR_GETREQUEST,BEHAVIOUR_INITIALISATION,1);
		behaviour.registerDefaultTransition(BEHAVIOUR_DEBUT,BEHAVIOR_ENERGYADVERTISSEMENT);
		behaviour.registerDefaultTransition(BEHAVIOR_ENERGYADVERTISSEMENT,BEHAVIOUR_BOOKINGCONFIRMATION);
		addBehaviour(behaviour);
    	
   
    }
    
    public void Initialisation() {
    	DecimalFormat df = new DecimalFormat("#.##");
    	Random rd = new Random();
    	int t = rd.nextInt(2);
    	this.renewable = t==1?true:false;
    	this.quantity = 1 + rd.nextInt(5000);
    	this.selling_price = 1 + Double.parseDouble(df.format(rd.nextDouble()*1000000).replace(",", "."));
    	System.out.println(this);
    }

	@Override
	public String toString() {
		return "selling_price=" + selling_price + ",quantity=" + quantity + ",renewable=" + renewable;
	}
    
    /*private class HandleRequestsBehaviour extends CyclicBehaviour {
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
    }*/

    
    
    
}

