import java.io.*;
import java.nio.*;
import java.util.*;

public class MainQ {
    public static void main(String[] args) throws Exception {
	Agent ag = new AgentSimple("toto");
	AgentMultiple agglo = new AgentMultiple("titi");
	agglo.ajouter(ag);
	//agglo.afficher();
	Descripteur temperature_aggreg = new Descripteur("temperature_aggreg", "float", 20);
	Descripteur autreTemperature = new Descripteur("autre_temp","float");
	Caracteristique CGlucose = new BioAgent("Cglucose");
	CGlucose.ajouter(temperature_aggreg);
	CGlucose.ajouter(autreTemperature);
	ag.setCaracteristique(CGlucose);
	//ag.getCaracteristique().afficher();
	Experience exp= new Experience("exp");
	Process proces=new Process("fixe");
	exp.add_agent(ag);
	exp.add_agent(agglo);
	exp.add_process(proces);
	exp.ecrire();
	ag.ecrire();
	agglo.ecrire();
	//Parser parserAg = new Parser(System.getProperty("user.dir") + "/Agent.txt");
	//parserAg.processLineByLine();
	ArrayList<String> liste_exp = new ArrayList<String>();
	Parser parserExp = new Parser(System.getProperty("user.dir")+"/Exp.txt");
	liste_exp=parserExp.getListExp();
	for(String name : liste_exp){
	    System.out.println(name);
	}
	Experience retour = parserExp.getExp("test");
	retour.afficher();
    }
}
