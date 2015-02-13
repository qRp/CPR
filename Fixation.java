import java.util.*;

public class Fixation extends Process{
    private String name;
    private String type;
    private double coefficient;
    private ArrayList<Agent> agentsCibles = new ArrayList<Agent>();


    public Fixation(String nname, String ttype, double ccoeff){
	super(nname);
	type=ttype;
	coefficient=ccoeff;
    }
    public Fixation(String nname){
	super(nname);
	type="unknow";
	coefficient=1.0;
    }
    public String getname(){
	return name;
    }
    public String gettype(){
	return type;
    }
    public double getcoefficient(){
	return coefficient;
    }
    public ArrayList<Agent> getAgentsCibles(){
	return agentsCibles;
    }
    public void setname(String nname){
	name=nname;
    }
    public void settype(String ttype){
	type=ttype;
    }
    public void setcoefficient(double ccoef){
	coefficient=ccoef;
    }
    public void setAgentsCibles(ArrayList<Agent> aagents){
	agentsCibles=aagents;
    }
    public void add_agentCible(Agent agent){
	agentsCibles.add(agent);
    }


}
