import java.util.*;
import java.io.*;

public class Descripteur{
    private String name;
    private String type;
    private float value;
    private float minV;
    private float maxV;
    private float pasV; //sous le pasV, la plage
    private ArrayList<Float> lValue = new ArrayList<Float>();

    public Descripteur(String nname){
	name=nname;
    }
    public Descripteur(String nname, String ntype, float nvalue){
	    name = nname;
	    type = ntype;
	    value = nvalue;
	    minV = nvalue;
    	maxV = nvalue;
        pasV = 0;
    }   
    
    public Descripteur(String nname, String ntype, float nvalue, float minValue, float maxValue, float pasValue){
	    name = nname;
	    type = ntype;
	    value = nvalue;
	    minV = minValue;
    	maxV = maxValue;
        pasV = pasValue;
    }
    
    public Descripteur(String nname, String ntype){
	    name = nname;
	    type = ntype;
	    value = 0;
    }
    public String getname(){
	    return name;
    }
    public String gettype(){
	    return type;
    }
    public float getvalue(){
        return value;
    }
    public float getminV(){
	return minV;
    }
    public float getmaxV(){
	return maxV;
    }
    public float getpasV(){
	return pasV;
    }
    public void setname(String nname){
	    name=nname;
    }
    public void settype(String ttype){
	    type=ttype;
    }
    public void setvalue(float vvalue){
        value=vvalue;
    }
    public void setminV(float mminV){
	minV=mminV;
    }
    public void setmaxV(float mmaxV){
	maxV=mmaxV;
    }
    public void setpasV(float ppasV){
	pasV=ppasV;
    }
    public ArrayList<Float> getvalues(){
        lValue.add(value);
        lValue.add(minV);
        lValue.add(maxV);
        lValue.add(pasV);
	    return lValue;
    }
    public void afficher(){
	System.out.println(getname());
	System.out.println(gettype());
	System.out.println(getvalue());
	System.out.println(getminV());
	System.out.println(getmaxV());
	System.out.println(getpasV());
    }
    public void ecrire(){
	//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
	String adressedufichier = System.getProperty("user.dir") + "/Descripteur.txt";
	try{
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
		output.write("type:"+gettype()+"\n");
		String temp=Float.toString(getvalue());
		output.write("value:"+temp+"\n");
		temp=Float.toString(getminV());
		output.write("minV:"+temp+"\n");
		temp=Float.toString(getmaxV());
		output.write("maxV:"+temp+"\n");
		temp=Float.toString(getpasV());
		output.write("pasV:"+temp+"\n");		

		//on peut utiliser plusieurs fois methode write
		
		output.flush();
		//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
		
		output.close();
		//et on le ferme
		System.out.println("fichier créé");
	}
	catch(IOException ioe){
	    System.out.print("FATAL ERROR SYSTEM - Descripteur.java ");
	    ioe.printStackTrace();
	}
	
    }
}

