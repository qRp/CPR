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
	ArrayList<Agent> test = new ArrayList<Agent>();
	test.add(ag);
	Experience exp= new Experience("exp");
	exp.add_agent(ag);
	exp.add_agent(agglo);
	ag.ecrire();
	Parser parserAg = new Parser(System.getProperty("user.dir") + "/Agent.txt");
	//Agent test=parserAg.getAgent("tatait");
	//test.afficher();
	Descripteur descripteur = new Descripteur("test_descripteur","String",1,0,100,1);
	descripteur.ecrire();
	Parser parserDescripteur = new Parser(System.getProperty("user.dir")+"/Descripteur.txt");
	Descripteur testdescripteur = parserDescripteur.getDescripteur("test_descripteur");
	testdescripteur.afficher();
	
	Environnement env = new Environnement(20,20,20,"testEnvironnement");
	exp.setEnvironnement(env);
	SaveNetlogo sn = new SaveNetlogo(exp);
	sn.writeFile();
    }
}
