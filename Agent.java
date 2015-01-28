public class Agent {
    private String name;
    private Caracteristique type;

    public Agent(String nname){
	name=nname;
    }
    public void setCaracteristique(Caracteristique ncarac){
	type=ncarac;
    }
    public Caracteristique getCaracteristique(){
	return type;
    }

    public String getname(){
	return name;
    }
    public void afficher(){
	System.out.println(name);
    }


    
}
