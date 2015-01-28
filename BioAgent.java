import java.util.*;

public class BioAgent extends Caracteristique{
    private String name;
    private ArrayList<Descripteur> descripteurs = new ArrayList<Descripteur>();


    public BioAgent(String nname){
	name=nname;
    }
    public void ajouter(Descripteur d){
	descripteurs.add(d);
    }
    public void afficher(){
	for(Descripteur descripteur : descripteurs){
	    System.out.println(descripteur.getname());
	}
    }

}