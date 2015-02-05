import java.io.*;


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
	System.out.println(type.getname());
    }

    public void setname(String nname){
	name=nname;
    }

    
    public void ecrire(){
	//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
	String adressedufichier = System.getProperty("user.dir") + "/Agent.txt";
	try
	    {
		FileWriter fw = new FileWriter(adressedufichier, true);
		// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
		BufferedWriter output = new BufferedWriter(fw);
		
		//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
		output.write("name:"+getname()+"\n");
		output.write("caracteristique:"+getCaracteristique().getname()+"\n");
		//on peut utiliser plusieurs fois methode write
		
		output.flush();
		//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
		
		output.close();
		//et on le ferme
	    }
	catch(IOException ioe){
	    System.out.print("Erreur : ");
	    ioe.printStackTrace();
	}
	
    }

    
}
