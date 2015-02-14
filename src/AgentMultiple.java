import java.util.*;

public class AgentMultiple extends Agent {
    private String name;
    private ArrayList<Agent> agents = new ArrayList<Agent>();

    public AgentMultiple(String nname){
	super(nname);
    }
    public void ajouter(Agent a){
	agents.add(a);
    }
    public void afficher(){
	for(Agent agent : agents){
	    System.out.println(agent.getname());
	}
    }
    
}
