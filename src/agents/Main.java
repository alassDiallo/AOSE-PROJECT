package agents;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import agents.MarketplaceAgent;

public class Main {
	public static void main(String[] args) {
		Runtime runtime = Runtime.instance();
		Profile config = new ProfileImpl("localhost", 8888, null);
		config.setParameter("gui", "true");
		AgentContainer mc = runtime.createMainContainer(config);
		AgentController ac1;
		AgentController pd1;
		AgentController pd2;
		AgentController ac3;
		try {
			long startTime = System.nanoTime();
			ac1 = mc.createNewAgent("MarketplaceAgent", MarketplaceAgent.class.getName(), null);
			pd1 = mc.createNewAgent("ProducerAgent1", ProducerAgent.class.getName(), null);
			pd2 = mc.createNewAgent("ProducerAgent2", ProducerAgent.class.getName(), null);
			ac3 = mc.createNewAgent("ConsumerAgent", ConsumerAgent.class.getName(), null);
			ac1.start();
			pd1.start();
			pd2.start();
			ac3.start();
			 long endTime = System.nanoTime();
		        long duration = (endTime - startTime) / 1000000;  // Convertir en millisecondes
		        System.out.println("exécution time: " + duration + " ms");
		} catch (StaleProxyException e) {
		}
	}
}

