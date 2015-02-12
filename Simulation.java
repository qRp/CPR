import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.util.*;
import java.io.*;


public class Simulation extends JFrame {
	JLabel label = new JLabel("");
	JLabel labtitre = new JLabel("");
	
	JLabel lab1 = new JLabel("");
	JLabel lab2 = new JLabel("");
	JLabel lab3 = new JLabel("");
	JLabel lab4 = new JLabel("");

	JPanel pan = new JPanel();
	
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	
	String name = "";
	JOptionPane jop = new JOptionPane();
	
	int x, y, z ;
	JFormattedTextField saisieX = new JFormattedTextField(new Integer(x));
	JFormattedTextField saisieY = new JFormattedTextField(new Integer(y));
	JFormattedTextField saisieZ = new JFormattedTextField(new Integer(z));
	JPanel envX = new JPanel();
	JPanel envY = new JPanel();
	JPanel envZ = new JPanel();
	boolean env = false;
	
	JFormattedTextField saisiePop = new JFormattedTextField();
	
	public Simulation(String titre) {
		super(titre);
		//this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBackground(Color.white);
		this.setLocationRelativeTo(this);
		this.setSize(840, 600);
		
	
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);

		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
				
		// Titre
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 2;
		pan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		pan.setBackground(Color.GRAY);
		//pan.setPreferredSize(getMaximumSize());
		label.setForeground(Color.orange);
		label.setText(titre);
		label.setFont(new Font("Courier", Font.BOLD, 30));
		label.setBorder(BorderFactory.createEmptyBorder(0,70,70,00));
		labtitre.setText("Simulation");
		labtitre.setFont(new Font("Capitals", Font.PLAIN, 18));
		labtitre.setBorder(BorderFactory.createEmptyBorder(70,0,0,50));
		ImageIcon icone = new ImageIcon("ag.jpg");
		JLabel img = new JLabel("", icone, JLabel.LEFT);
		img.setIconTextGap(10);
		img.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
		pan.add(img);
		pan.add(label);
		pan.add(labtitre);
		this.add(pan, gbc);
		
		// Environnement
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		lab1.setText("Environnement");
		lab1.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab1.setForeground(new Color(136, 66, 29));
		
		lab1.setPreferredSize(new Dimension(300, 100));
		lab1.setHorizontalAlignment(0);
		this.add(lab1, gbc);
		// Champs de saisie pour x, y, z
		gbc.gridx = 0;
		gbc.gridy = 3;
		saisieX.setPreferredSize(new Dimension(30, 20));
		envX.add(new JLabel("X :"));
		envX.add(saisieX);
		this.add(envX, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		saisieY.setPreferredSize(new Dimension(30, 20));
		envY.add(new JLabel("Y :"));
		envY.add(saisieY);
		this.add(envY, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		saisieZ.setPreferredSize(new Dimension(30, 20));
		envZ.add(new JLabel("Z :"));
		envZ.add(saisieZ);
		this.add(envZ, gbc);
		
		
		// Agents
		gbc.gridx = 1;
		gbc.gridy = 2;
		lab2.setText("Agents");
		lab2.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab2.setForeground(new Color(136, 66, 29));
		lab2.setPreferredSize(new Dimension(300, 100));
		lab2.setHorizontalAlignment(0);
		this.add(lab2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		b2.setText("Creer");
		b2.setEnabled(true);
		b2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		agent();
		 	}
		 });
		this.add(b2, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		ArrayList<String> Lagent = new ArrayList<String>();
		Parser parserAgent = new Parser(System.getProperty("user.dir")+"/Agent.txt");
		try{
		    Lagent = parserAgent.getListAgent();
		}catch(IOException e){
		    int toto=0;
		}
		String c4 [] = new String[Lagent.size()];
		int i=0;
		for(String str : Lagent){
		    c4[i]=str;
		    i++;
		}
		JList list4 = new JList(c4);
		JScrollPane scroll3 = new JScrollPane(list4);
		scroll3.createVerticalScrollBar();
		this.add(scroll3, gbc);
		
		//Population
		gbc.gridx = 2;
		gbc.gridy = 2;
		lab3.setText("Population");
		lab3.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab3.setForeground(new Color(136, 66, 29));
		lab3.setPreferredSize(new Dimension(300, 100));
		lab3.setHorizontalAlignment(0);
		this.add(lab3, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		try{
		    MaskFormatter mask = new MaskFormatter("AAA"); // indique que le champ doit contenir : 3 chiffres ou lettres
/*
 * Pour le mask :
 * chiffre : #
 * caractere d'echappement : '
 * lettre (les minuscules sont automatiquement changees en majuscules) : U
 * lettre (les majuscules sont automatiquement changees en minuscules) : L
 * chiffre ou lettre : A
 * lettre : ?
 * tous les caracteres : *
 * tous les caracteres hexadecimaux sont acceptes (0-9, a-f et A-F) : H
 */
		    mask.install(saisiePop);
		}catch(ParseException e){e.printStackTrace();}
		saisiePop.setPreferredSize(new Dimension(100, 50));
		this.add(saisiePop, gbc);
		
		// Logiciels
		gbc.gridx = 3;
		gbc.gridy = 2;
		lab4.setText("Logiciels");
		lab4.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab4.setForeground(new Color(136, 66, 29));
		lab4.setPreferredSize(new Dimension(300, 100));
		lab4.setHorizontalAlignment(0);
		this.add(lab4, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3;
		String tabLog[] = {"NetLogo", "Log1", "Log2"};
		JComboBox listLog = new JComboBox(tabLog);
		listLog.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		JComboBox cb = (JComboBox)e.getSource();// chaque element de la CB
		        //String name = (String)cb.getSelectedItem();
		        //updateLabel();
		 		//System.out.println("combo");
		 	}
		 });
		this.add(listLog,gbc);
		
		// Ajoute une ligne vide
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 4;
		this.add(new JLabel(" "), gbc);
		
		// Suivant
		gbc.gridx = 0;
		gbc.gridy = 7;
		b3.setText("Suivant");
		b3.setEnabled(true);
		b3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		run();
		 	}
		 });
		this.add(b3, gbc);
		
		// Ajoute une ligne vide
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(new JLabel(" "), gbc);
		
		pack();
		
	}
	
	public boolean getTextEnvX(){
		try {
			x = new Integer(saisieX.getText()).intValue();
			y = new Integer(saisieY.getText()).intValue();
			z = new Integer(saisieZ.getText()).intValue();
			if (x == 0 || y == 0 || z == 0){
				jop.showMessageDialog(null, "Vous devez remplir tous les champs !", "Attention", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			else{
				env = Fenetre.environnement(x,y,z);
				return true;
			}
			
		} 
	    catch(NullPointerException npe) {
	        System.out.println("Saisie annulee"); 
	        this.dispose();
	        return false;
	    }
	}
	
	public String nameExp() {
        try { 
           do {
        	   name = JOptionPane.showInputDialog(null, "Saisir le nom de l'experience\nCaracteres autorises alphanumeriques"); 
        	   //Si on annule c'est la ligne suivante qui provoque la levee de NullPointerException 
        	   if (name.equals(null)) {} // on ne fait rien
        	   if (name.matches("([0-9a-zA-Z-])+") == false) {}
        	   //System.out.println("Fin de saisie sans rien frapper au clavier");
        	   } while (name.equals("") || name.matches("([0-9a-zA-Z-])+") == false);
           return name;
           } 
        catch(NullPointerException npe) // cas <annuler> : uneEntree.equals(null) 
        {
        	System.out.println("Saisie annulee par le clic du bouton <Annuler>"); 
        	this.dispose();
            return "";
            } 
	}
	
	public void agent(){
		AgentGraphique agg = new AgentGraphique(this.getTitle());
 		agg.setVisible(true);
	}
	
	public void run(){
		System.out.println("run");
		/*
		 * D'abord doit verifier si tous les champs sont remplis
		 * Puis envoie vers la page Comportements Agents
		 */
		//verification des champs de Environnement
		boolean envOk = false;
		if (!envOk){
			envOk = getTextEnvX();
		}
		//boolean envOk = true; //pour le test
		if (envOk) {
			ComportementsAgent cptA = new ComportementsAgent(this.getTitle());
			cptA.setVisible(true);
		}
	}
}
