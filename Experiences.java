import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.*;


public class Experiences extends JFrame {
	JLabel label1 = new JLabel("");
	
	JList li = new JList();
	JScrollPane scp = new JScrollPane(li);

	public Experiences(String titre) {
		super(titre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBackground(Color.white);
		this.setLocationRelativeTo(this);
		this.setSize(840, 600);
		
		//Fenetre fen = new Fenetre(titre);
		//fen.barreMenu();
		//fen.setVisible(true);
		
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
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		label1.setPreferredSize(new Dimension(300, 100));
		label1.setHorizontalAlignment(0);
		label1.setForeground(Color.red);
		label1.setText(titre);
		this.add(label1, gbc);
		
		// JList ScollPlane
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		String choix[] = {"A","B","C"};
		JList l = new JList(choix);
		JScrollPane scp = new JScrollPane(l);
		this.add(scp, gbc);
		
		System.out.println("test");
		
	}
}
