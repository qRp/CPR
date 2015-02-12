import java.io.*;
import java.nio.*;
import java.util.*;

public class MainQ {
    public static void main(String[] args) throws Exception {
	Agent ag = new AgentSimple("tata");
	AgentMultiple agglo = new AgentMultiple("titi");
	agglo.ajouter(ag);
	//agglo.afficher();
	Descripteur temperature_aggreg = new Descripteur("temperature_aggreg", "float", 
	20);
	Descripteur autreTemperature = new Descripteur("autre_temp","float");
	Caracteristique CGlucose = new BioAgent("Cglucose");
	CGlucose.setname("Glucose");
	CGlucose.ajouter(temperature_aggreg);
	CGlucose.ajouter(autreTemperature);
	ag.setCaracteristique(CGlucose);
	agglo.setCaracteristique(CGlucose);
	Experience exp= new Experience("exp");
	Process proces=new Process("fixe");
	exp.add_agent(ag);
	exp.add_agent(agglo);
	exp.add_process(proces);
	ag.ecrire();
	Parser parserAg = new Parser(System.getProperty("user.dir") + "/Agent.txt");
	//Agent test=parserAg.getAgent("tatait");
	//test.afficher();
	
	Environnement env = new Environnement(20,20,20,"testEnvironnement");
	SaveNetlogo sn = new SaveNetlogo(exp);
	sn.writeFile();
    }
}
