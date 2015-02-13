import java.util.*;


public class Process{
    private String name;
    private Agent agent;
    private ArrayList<Agent> agentsCibles = new ArrayList<Agent>();

    public Process(String nname){
	name=nname;
    }
    public String getname(){
	return name;
    }
    public void afficher(){
	System.out.println(name);
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
}
