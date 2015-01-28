public class Agent {
    private String name;
//    private TypeAgent type;

    Agent(String nname){
	name=nname;
	
    }
    public String getname(){
	return name;
    }
    public void afficher(){
	System.out.println(name);
    }


    
}
