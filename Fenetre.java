import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;


public class Fenetre extends JFrame {

	JLabel label1 = new JLabel("");

	JButton bout1 = new JButton();
	JButton bout2 = new JButton();
	JButton bout3 = new JButton();


	/** Constructeur.
	 * 
	 * @param titre : titre de la fenetre
	 */
	public Fenetre(String titre) {
		super(titre);
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon_game.gif"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
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
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		this.add(new JLabel(" "), gbc);
		// Label Titre de la fenetre
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		label1.setPreferredSize(new Dimension(300, 100));
		//label1.setBorder(BorderFactory.createRaisedBevelBorder());
		label1.setHorizontalAlignment(0);
		label1.setForeground(Color.red);
		label1.setText(titre);
		this.add(label1, gbc);

		// Label Gestion molecules
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(new JLabel("Gestion des molecules", JLabel.LEFT), gbc);

		// Button 
		gbc.gridx = 0;
		gbc.gridy = 3;
		bout1.setText("Molecules");
		bout1.setSize(220, 110);
		bout1.setEnabled(true);
		// bout1.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		okJoueur1();
		// 	}
		// });
		this.add(bout1, gbc);

		// Label Gestion experiences
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(new JLabel("Gestion des experiences"), gbc);

		// Button 
		gbc.gridx = 1;
		gbc.gridy = 3;
		bout2.setText("Experiences");
		bout2.setSize(120, 10);
		bout2.setEnabled(true);
		// bout1.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		okJoueur1();
		// 	}
		// });
		this.add(bout2, gbc);

		// Button quitter
		gbc.gridx = 1;
		gbc.gridy = 4;
		bout3.setText("Quitter");
		bout3.setSize(120, 10);
		bout3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitter();
			}
		});
		this.add(bout3, gbc);

		// Ajoute une ligne vide
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		this.add(new JLabel(" "), gbc);

		// Reduire la fenetre a sa juste valeur pour contenir le tout
		//pack();

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
		JMenuItem menuNouveau = new JMenuItem("Nouvelle partie");
		//menuNouveau.setIcon(new ImageIcon("icon_game.gif"));
		menuNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nouveau();
			}
		});
		menuFichier.add(menuNouveau);
		menuFichier.addSeparator();
		JMenuItem menuOuvrir = new JMenuItem("Charger partie");
		menuOuvrir.setIcon(new ImageIcon("load.gif"));
		menuOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charger();
			}
		});
		menuFichier.add(menuOuvrir);
		JMenuItem menuSauver = new JMenuItem("Sauver partie");
		menuSauver.setIcon(new ImageIcon("save.gif"));
		menuSauver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sauver();
			}
		});
		menuFichier.add(menuSauver);
		menuFichier.addSeparator();
		JMenuItem menuQuitter = new JMenuItem("Quitter le jeu");
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

	/** Permet de controler quand le programme est quitter.
	 * 
	 */
	public void quitter() {
		//JOptionPane.showConfirmDialog(this,"Voulez-vous quitter ?");
		System.exit(0);
	}


	
	/** Une nouvelle partie va commencer.
	 * 
	 */
	public void nouveau() {
		JOptionPane.showMessageDialog(this,"Nouveau\n");
	}

	/** Affiche les regles du jeu.
	 * 
	 */
	public void regleJeu() {
		JOptionPane.showMessageDialog(this,"Regles\n");
	}

	/** Affiche une boite d'information
	 * 
	 */
	public void apropos() {
		JOptionPane
				.showMessageDialog(
						this,
						"Programme ecrit en Java\n\n"
								+ "par \n\nCopyright "
								+ "Master Bioinformatique 2014-2015");

	}

	/** Permet de sauvegarder la position des elements sur le tableau de jeu.
	 * 
	 */
	public void sauver() {
		JOptionPane.showMessageDialog(this,"Sauver\n");
	}

	/** Permet de restaurer un jeu anterieur.
	 * 
	 */
	public void charger() {
		JOptionPane.showMessageDialog(this,"Charger\n");
	}

}
