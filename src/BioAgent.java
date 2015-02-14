import java.util.*;

public class BioAgent extends Caracteristique{
    private String name;
    private ArrayList<Descripteur> descripteurs = new ArrayList<Descripteur>();


    public BioAgent(String nname){
	    super(nname);
    }
    public void ajouter(Descripteur d){
	    descripteurs.add(d);
    }
    public void afficher(){
	    System.out.println(name);
	    for(Descripteur descripteur : descripteurs){
	        System.out.println(descripteur.getname());
	    }
    }
    
    public ArrayList<Descripteur> getDescripteur(){
    /*
        for(Descripteur descripteur : descripteurs){
            System.out.println(descripteur.getname());
            System.out.println(descripteur.gettype());
            System.out.println(descripteur.getvalue());
        }
    */
        return descripteurs;
    }
    
    public String getname(){
	    String str = super.getname()+this.name;
	    return str;
    }
    public void setname(String nname){
	    name=nname;
	}

}
