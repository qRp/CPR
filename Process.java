import java.util.*;


public class Process{
    private String name;
    private ArrayList<Agent> lagent = new ArrayList<Agent>();


    public Process(String nname){
	name=nname;
    }
    public String getname(){
	return name;
    }
    public void afficher(){
	System.out.println(name);
    }
    
}