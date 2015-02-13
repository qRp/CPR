import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultEditorKit;

import java.util.*;


public class Fenetre extends JFrame {

	JLabel label1 = new JLabel("");
	JLabel lab = new JLabel("");
	JPanel pan = new JPanel();
	JPanel pan2 = new JPanel();
	
	JLabel label2 = new JLabel("");
	JLabel label3 = new JLabel("");
	JLabel label4 = new JLabel("");

	JButton bout1 = new JButton();
	JButton bout2 = new JButton();
	JButton bout3 = new JButton();
	JButton b4 = new JButton();
	
	JList list1;

	/** Constructeur.
	 * 
	 * @param titre : titre de la fenetre
	 */
	public Fenetre(String titre) {
		super(titre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBackground(Color.white);
		this.setLocationRelativeTo(this);
		this.setSize(840, 600);

		// Initialisation de la barre de menu
		barreMenu();

		// definition du GridBagLayout
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;

		// Titre
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3; // nb colonne
		gbc.gridheight = 2; //nb ligne
		pan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		pan.setBackground(Color.GRAY);
		label1.setForeground(Color.orange);
		label1.setText(titre);
		label1.setFont(new Font("Courier", Font.BOLD, 30));
		label1.setBorder(BorderFactory.createEmptyBorder(0,70,70,0));
		lab.setText("Simulation de systemes multi-agents");
		lab.setFont(new Font("TimesRoman", Font.ITALIC, 11));
		lab.setBorder(BorderFactory.createEmptyBorder(70,0,0,50));
		ImageIcon icone = new ImageIcon("ag.jpg");
		JLabel img = new JLabel("", icone, JLabel.LEFT);
		img.setIconTextGap(10);
		img.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
		pan.add(img);
		pan.add(label1);
		pan.add(lab);
		this.add(pan, gbc);
		
		// Gestion molecules
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		label2.setText("Gestion des molecules");
		label2.setFont(new Font("Capitals", Font.PLAIN, 20));
		label2.setForeground(new Color(136, 66, 29));
		label2.setPreferredSize(new Dimension(300, 100));
		label2.setHorizontalAlignment(0);
		this.add(label2, gbc); 
		gbc.gridx = 0;
		gbc.gridy = 3;
		bout1.setText("Molecules");
		bout1.setEnabled(true);
		bout1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		molecule();
		 	}
		 });
		this.add(bout1, gbc);

		// Gestion experiences
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		label3.setText("Gestion des experiences");
		label3.setFont(new Font("Capitals", Font.PLAIN, 20));
		label3.setForeground(new Color(136, 66, 29));
		label3.setPreferredSize(new Dimension(300, 100));
		label3.setHorizontalAlignment(0);
		this.add(label3, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		bout2.setText("Experiences");
		bout2.setSize(120, 10);
		bout2.setEnabled(true);
		bout2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				experience();
		 	}
		 });
		this.add(bout2, gbc);
		
		// Visualisation resultats
		gbc.gridx = 2;
		gbc.gridy = 2;
		label4.setText("Resultats");
		label4.setFont(new Font("Capitals", Font.PLAIN, 20));
		label4.setForeground(new Color(231, 62, 1));
		label4.setPreferredSize(new Dimension(300, 150));
		label4.setHorizontalAlignment(0);
		label4.setBorder(BorderFactory.createMatteBorder(0,5,0,0,new Color(231, 62, 1)));
		this.add(label4, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		b4.setText("Visualiser");
		b4.setEnabled(true);
		b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
			visu();
			}
		});
		this.add(b4, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridheight = 2;
		ArrayList<String> Lexp = new ArrayList<String>();
		Parser parserExp = new Parser(System.getProperty("user.dir")+"/Exp.txt");
		try{
		    Lexp = parserExp.getListExp();
	    }
		catch(IOException e){
			System.out.println("FATAL ERROR SYSTEM - Fenetre.java");
		}
		String tab1 [] = new String[Lexp.size()];
		int i=0;
		for(String str : Lexp){
		    tab1[i]=str;
		    i++;
		}
		list1 = new JList(tab1);
		JScrollPane scroll = new JScrollPane(list1);
		scroll.createVerticalScrollBar();
		this.add(scroll, gbc);		
		
		// Ligne vide
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 2;
		this.add(new JLabel(" "), gbc);

		// Bouton Quitter
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		bout3.setText("Quitter");
		bout3.setSize(120, 10);
		bout3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitter();
			}
		});
		this.add(bout3, gbc);

		// Ligne vide
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 3;
		this.add(new JLabel(" "), gbc);

		pack();

	}
	
	public void molecule(){
		AgentGraphique ag = new AgentGraphique(this.getTitle());
		ag.setVisible(true);
	}
	
	public void experience(){
		Simulation expG = new Simulation(this.getTitle());
 		expG.setVisible(true);
 		String name = expG.nameExp();	
	}
	
	public void visu(){
		System.out.println("visu");
	}
	
	
	
	/** Creation de la barre de menu.
	 * 
	 */
	public void barreMenu() {
		JMenuBar menuPrincipal = new JMenuBar();
		this.setJMenuBar(menuPrincipal);
		JMenu menuFichier = new JMenu("Fichier");
		JMenu menuEdition = new JMenu("Edition");
		JMenu menuAide = new JMenu("Aide");
		menuPrincipal.add(menuFichier);
		menuPrincipal.add(menuEdition);
		menuPrincipal.add(menuAide);
		
		// Menu Fichier
		JMenuItem menuNouveau = new JMenuItem("Nouvelle simulation");
		menuNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nouveau();
			}
		});
		menuFichier.add(menuNouveau);
		menuFichier.addSeparator();
		JMenuItem menuOuvrir = new JMenuItem("Charger simulation");
		menuOuvrir.setIcon(new ImageIcon("load.gif"));
		menuOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charger();
			}
		});
		menuFichier.add(menuOuvrir);
		JMenuItem menuSauver = new JMenuItem("Sauver simulation");
		menuSauver.setIcon(new ImageIcon("save.gif"));
		menuSauver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sauver();
			}
		});
		menuFichier.add(menuSauver);
		menuFichier.addSeparator();
		JMenuItem menuQuitter = new JMenuItem("Quitter");
		menuQuitter.setIcon(new ImageIcon("window-close.gif"));
		menuQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitter();
			}
		});
		menuFichier.add(menuQuitter);
		
		// Menu Edition
		JMenuItem menuCouper = new JMenuItem(new DefaultEditorKit.CutAction());
		menuCouper.setText("Couper");
		menuCouper.setIcon(new ImageIcon("edit-cut.gif"));
		menuEdition.add(menuCouper);
		JMenuItem menuCopier = new JMenuItem(new DefaultEditorKit.CopyAction());
		menuCopier.setText("Copier");
		menuCopier.setIcon(new ImageIcon("edit-copy.gif"));
		menuEdition.add(menuCopier);
		JMenuItem menuColler = new JMenuItem(new DefaultEditorKit.PasteAction());
		menuColler.setText("Coller");
		menuColler.setIcon(new ImageIcon("edit-paste.gif"));
		menuEdition.add(menuColler);

		// Menu Aide
		JMenuItem menuRegle = new JMenuItem("Regle");
		menuRegle.setIcon(new ImageIcon("help.gif"));
		menuRegle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regleJeu();
			}
		});
		JMenuItem menuApropos = new JMenuItem("a propos de ...");
		menuApropos.setIcon(new ImageIcon("a_propos.gif"));
		menuApropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apropos();
			}
		});
		menuAide.add(menuRegle);
		menuAide.addSeparator();
		menuAide.add(menuApropos);

	}

	public void quitter() {
		System.exit(0);
	}

	public void nouveau() {
		JOptionPane.showMessageDialog(this,"Nouveau\n");
	}

	public void regleJeu() {
		JOptionPane.showMessageDialog(this,"Regles\n");
	}

	public void apropos() {
		JOptionPane.showMessageDialog(
						this,
						"Programme ecrit en Java\n\n"
								+ "par BESSY Arien\nDROUINEAU Emilie\nMERSCH Marjorie\nRICHE-PIOTAIX Quentin\n\nCopyright "
								+ "Master 2 Bioinformatique 2014-2015");

	}

	public void sauver() {
		JOptionPane.showMessageDialog(this,"Sauver\n");
	}


	public void charger() {
		JOptionPane.showMessageDialog(this,"Charger\n");
	}

}
