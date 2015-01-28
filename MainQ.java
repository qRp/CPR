
public class MainQ {
    public static void main(String[] args) throws Exception {
	Agent ag = new AgentSimple("toto");
	AgentMultiple agglo = new AgentMultiple("titi");
	agglo.ajouter(ag);
	agglo.afficher();
	Descripteur temperature_aggreg = new Descripteur("temperature_aggreg", "float", 20);
	Descripteur autreTemperature = new Descripteur("autre_temp","float");
	Caracteristique CGlucose = new BioAgent("Cglucose");
	CGlucose.ajouter(temperature_aggreg);
	CGlucose.ajouter(autreTemperature);
	ag.setCaracteristique(CGlucose);
	ag.getCaracteristique().afficher();

    }
}
