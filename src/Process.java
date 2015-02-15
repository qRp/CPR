import java.util.*;


public class Process{
    protected String name;
    protected Agent agent;
    protected ArrayList<Agent> agentsCibles = new ArrayList<Agent>();

    public Process(String nname,Agent aagent, ArrayList<Agent> aagentsCibles){
	name=nname;
	agent=aagent;
	agentsCibles=aagentsCibles;
    }
    public Process(String nname){
	name=nname;
    }
    public String getname(){
	return name;
    }
    public void afficher(){
	System.out.println(name);
	agent.afficher();
	for(Agent aagent : agentsCibles){
	    aagent.afficher();
	    }
    }
    public ArrayList<Agent> getAgentsCibles(){
	return agentsCibles;
    }
    public void setAgentsCibles(ArrayList<Agent> aagents){
	agentsCibles=aagents;
    }
    public void add_agentCible(Agent agent){
	agentsCibles.add(agent);
    }
    public Agent getAgent(){
    	return agent;
    }
    public void setAgent(Agent aagent){
    	agent = aagent;
    }
}
