import java.util.*;


public class Process{
    private String name;
    private Agent agent;


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