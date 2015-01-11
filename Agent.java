public class Agent{
    private String nom;
    private int taille;
    private int demivie;

    
    public Agent(String nnom, int ntaille, int ndemivie){
	nom=nnom;
	taille=ntaille;
	demivie=ndemivie;
    }
    public Agent(agent agent_modele){
	nom=agent_model.nom;
	taille=agent_model.taille;
	demi_vie=agent_modele.demivie;
    }
    public void creer(String nom, int taille, int demivie){
	agent monagent=new agent(nom, taille, demivie);
	//ecrire monagent dans le XML	
    }

    public void modifier(String nom){
	//chercher agent dans le XML et le retourner, on l'appelera "agent_modele"
	//récupérer nouvelle valeur, en fenetre graphique ?
	//set la nouvelle valeur, suppression de l'ancienne entrée et réécriture dans le xml
	

    }

    public void supprimer(){
	//chercher agent dans le XML
	//verifier dans le XML experience s'il est présent
	//si non, le supprimer
	//si oui, message
    }

    //les get et set
    public int gettaille()
    {return taille;}
    public String getnom()
    {return nom;}
    public int getdemivie()
    {return demivie;}
    public void settaille(int n_taille)
    {taille=n_taille;}
    public void setnom(String n_nom)
    {nom=n_nom;}
    public void setdemivie(int n_demivie)
    {demivie=n_demivie}
}