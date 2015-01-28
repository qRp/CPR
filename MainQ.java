
public class MainQ {
    public static void main(String[] args) throws Exception {
	Agent ag = new AgentSimple("toto");
	AgentMultiple agglo = new AgentMultiple("titi");
	agglo.ajouter(ag);
	agglo.afficher();

    }
}
