import java.util.*;
import java.io.*;

public class Experience{
    private String name;
    private ArrayList<Process> lprocess = new ArrayList<Process>();
    private ArrayList<Agent> lagent = new ArrayList<Agent>();
    ptivate Environnement environnement;

    public Experience(String nname){
	name=nname;
    }
    public Environnement getenvironnement(){
	return environnement;
    }
    public void add_process(Process process){
	lprocess.add(process);
    }
    public void add_agent(Agent agent){
	lagent.add(agent);
    }
    public String getname(){
	return name;
    }
    public ArrayList getlprocess(){
	return lprocess;
    }
    public ArrayList getlagent(){
	return lagent;
    }
    public void afficher(){
	System.out.println("Affichage de l'experience");
	System.out.println(name);
	for(Agent agent : lagent){
	    agent.afficher();
	}
	for(Process process : lprocess){
	    process.afficher();
	}
    }
    public void ecrire(){
	//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
	String adressedufichier = System.getProperty("user.dir") + "/Exp.txt";
	try
	    {
		/**
		 * BufferedWriter a besoin d un FileWriter, 
		 * les 2 vont ensemble, on donne comme argument le nom du fichier
		 * true signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus 
		 
		 */
		FileWriter fw = new FileWriter(adressedufichier, true);
		// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
		BufferedWriter output = new BufferedWriter(fw);
		
		//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
		output.write("name:"+getname()+"\n");
		for(Process process : lprocess){
		    output.write("process:"+process.getname()+"\n");
		}
		for(Agent agent : lagent){
		    output.write("agent:"+agent.getname()+"\n");
		}
		//on peut utiliser plusieurs fois methode write
		
		output.flush();
		//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
		
		output.close();
		//et on le ferme
		System.out.println("fichier créé");
	    }
	catch(IOException ioe){
	    System.out.print("Erreur : ");
	    ioe.printStackTrace();
	}
	
    }
}
