import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Simulation extends JFrame {
	JLabel label = new JLabel("");
	JLabel lab = new JLabel("");
	JLabel lab1 = new JLabel("");
	JLabel lab2 = new JLabel("");
	JLabel lab3 = new JLabel("");

	JPanel pan = new JPanel();
	
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	
	String name = "";
	
	int x, y, z ;
	JFormattedTextField saisieX = new JFormattedTextField(new Integer(x));
	JFormattedTextField saisieY = new JFormattedTextField(new Integer(y));
	JFormattedTextField saisieZ = new JFormattedTextField(new Integer(z));
	JPanel envX = new JPanel();
	JPanel envY = new JPanel();
	JPanel envZ = new JPanel();
	
	boolean env = true;
	
	public Simulation(String titre) {
		super(titre);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		pan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		pan.setBackground(Color.GRAY);
		label.setForeground(Color.orange);
		label.setText(titre);
		label.setFont(new Font("Courier", Font.BOLD, 30));
		label.setBorder(BorderFactory.createEmptyBorder(0,70,70,0));
		lab.setText("Simulation de systemes multi-agents");
		lab.setFont(new Font("TimesRoman", Font.ITALIC, 11));
		lab.setBorder(BorderFactory.createEmptyBorder(70,0,0,50));
		ImageIcon icone = new ImageIcon("ag.jpg");
		JLabel img = new JLabel("", icone, JLabel.LEFT);
		img.setIconTextGap(10);
		img.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));
		pan.add(img);
		pan.add(label);
		pan.add(lab);
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
		String c4[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JList list4 = new JList(c4);
		JScrollPane scroll3 = new JScrollPane(list4);
		scroll3.createVerticalScrollBar();
		this.add(scroll3, gbc);

		// Logiciels
		gbc.gridx = 2;
		gbc.gridy = 2;
		lab3.setText("Logiciels");
		lab3.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab3.setForeground(new Color(136, 66, 29));
		lab3.setPreferredSize(new Dimension(300, 100));
		lab3.setHorizontalAlignment(0);
		this.add(lab3, gbc);
		gbc.gridx = 2;
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
		gbc.gridwidth = 3;
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
		BehaviourAgent bea = new BehaviourAgent(this.getTitle());
		bea.setVisible(true);
	}
}
