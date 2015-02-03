import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Simulation extends JFrame {
	JLabel label = new JLabel("");
	JLabel lab1 = new JLabel("");
	JLabel lab2 = new JLabel("");
	JLabel lab3 = new JLabel("");

	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	
	String name = "";
	JLabel saveName = new JLabel("");
	
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
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1; //nb lignes
		gbc.gridwidth = 1; //nb colonnes
		this.add(new JLabel(" "), gbc);
		
		// Titre
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		label.setPreferredSize(new Dimension(100, 100));
		label.setHorizontalAlignment(0);
		label.setForeground(Color.red);
		label.setText("Simulation");
		this.add(label, gbc);
		
		
		// Environnement
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		lab1.setText("Environnement");
		lab1.setForeground(Color.blue);
		lab1.setPreferredSize(new Dimension(100, 100));
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
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		lab2.setText("Agents");
		lab2.setForeground(Color.blue);
		lab2.setPreferredSize(new Dimension(100, 100));
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
		lab3.setForeground(Color.pink);
		lab3.setPreferredSize(new Dimension(100, 100));
		lab3.setHorizontalAlignment(0);
		this.add(lab3, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		String tabLog[] = {"NetLogo", "Log1", "Log2"};
		JComboBox listLog = new JComboBox(tabLog);
		listLog.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		JComboBox cb = (JComboBox)e.getSource();// chaque élement de la CB
		        //String name = (String)cb.getSelectedItem();
		        //updateLabel();
		 		//System.out.println("combo");
		 	}
		 });
		this.add(listLog,gbc);

		// Run
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		b3.setText("Suivant");
		b3.setEnabled(true);
		b3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		run();
		 	}
		 });
		this.add(b3, gbc);
		
		//pack();
		
	}
	/*
	 * A FAIRE :
	 * NE PAS METTRE D'EXTENSION DANS LE NOM DE L'EXP
	 * INTERDIRE LES CARACTERES EN DEHORS DE a-z A-Z 0-9 et '-'
	 */
	public void nameExp() {
		// Boite de dialogue de saisie des noms des experiences
		name = JOptionPane.showInputDialog("Saisir le nom de l'expérience");
		saveName.setText(name); // pour recup le nom
		//System.out.println(saveName);
		//return name;

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
