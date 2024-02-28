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
		AgentController ac2;
		AgentController ac3;
		try {
			ac1 = mc.createNewAgent("MarketplaceAgent", MarketplaceAgent.class.getName(), null);
			ac2 = mc.createNewAgent("ProducerAgent", ProducerAgent.class.getName(), null);
			ac3 = mc.createNewAgent("ConsumerAgent", ConsumerAgent.class.getName(), null);
			ac1.start();
			ac2.start();
			ac3.start();
		} catch (StaleProxyException e) {
		}
	}
}

