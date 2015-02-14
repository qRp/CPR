import java.util.*;

public class Fixation extends Process{
    //    private String name;
    private String type;
    private double coefficient;


    public Fixation(String nname, Agent aagent, ArrayList<Agent> aagentsCibles, String ttype, double ccoeff){
	super(nname, aagent, aagentsCibles);
	type=ttype;
	coefficient=ccoeff;
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
    public void setname(String nname){
	name=nname;
    }
    public void settype(String ttype){
	type=ttype;
    }
    public void setcoefficient(double ccoef){
	coefficient=ccoef;
    }

}
