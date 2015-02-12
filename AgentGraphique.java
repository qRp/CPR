import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class AgentGraphique extends JFrame {
	
	JLabel label = new JLabel("");
	JLabel lab = new JLabel("");
	JLabel lab1 = new JLabel("");
	JLabel lab2 = new JLabel("");
	JLabel lab3 = new JLabel("");
	JLabel lab4 = new JLabel("");
	JLabel lab5 = new JLabel("");
	JLabel lab6 = new JLabel("");
	JLabel lab7 = new JLabel("");
	JLabel lab8 = new JLabel("");
	JLabel lab9 = new JLabel("");
	
	JPanel pan = new JPanel();
	JPanel panNom = new JPanel();
	JPanel panDesc = new JPanel();
	JPanel panParam = new JPanel();
	JPanel panType = new JPanel();
	JPanel panVal = new JPanel();
	JPanel panMin = new JPanel();
	JPanel panMax = new JPanel();
	JPanel panInc = new JPanel();
	
	JButton b2 = new JButton();
	JButton b1 = new JButton();
	
	JFormattedTextField saisieNom = new JFormattedTextField();
	JFormattedTextField saisieDesc = new JFormattedTextField();
	JFormattedTextField saisieParam = new JFormattedTextField();
	JFormattedTextField saisieType = new JFormattedTextField();
	JFormattedTextField saisieVal = new JFormattedTextField();
	JFormattedTextField saisieMin = new JFormattedTextField();
	JFormattedTextField saisieMax = new JFormattedTextField();
	JFormattedTextField saisieInc = new JFormattedTextField();
	
	public AgentGraphique(String titre) {
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
		this.add(new JLabel(" "), gbc);
		
		// Titre
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 7;
		gbc.gridheight = 2;
		pan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		pan.setBackground(Color.GRAY);
		label.setForeground(Color.orange);
		label.setText(titre);
		label.setFont(new Font("Courier", Font.BOLD, 30));
		label.setBorder(BorderFactory.createEmptyBorder(0,70,70,0));
		
		lab.setText("Comportements des Agents");
		lab.setFont(new Font("Capitals", Font.PLAIN, 18));
		lab.setBorder(BorderFactory.createEmptyBorder(70,0,0,50));
		
		ImageIcon icone = new ImageIcon("ag.jpg");
		JLabel img = new JLabel("", icone, JLabel.LEFT);
		img.setIconTextGap(10);
		img.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
		pan.add(img);
		pan.add(label);
		pan.add(lab);
		this.add(pan, gbc);
		
		//Titre agents
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		lab1.setText("Nom de l'agent");
		lab1.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab1.setForeground(new Color(136, 66, 29));
		lab1.setPreferredSize(new Dimension(300, 100));
		lab1.setHorizontalAlignment(0);
		this.add(lab1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		//champ de saisie
		saisieNom.setPreferredSize(new Dimension(100, 30));
		panNom.add(saisieNom);
		this.add(panNom, gbc);
		
		//Description
		gbc.gridx = 0;
		gbc.gridy = 4;
		lab2.setText("Description");
		lab2.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab2.setForeground(new Color(136, 66, 29));
		lab2.setPreferredSize(new Dimension(300, 100));
		lab2.setHorizontalAlignment(0);
		this.add(lab2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		saisieDesc.setPreferredSize(new Dimension(100, 30));
		panDesc.add(saisieDesc);
		this.add(panDesc, gbc);
		
		//Ligne vide
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 7;
		this.add(new JLabel(" "), gbc);
		
		//Bouton titre + description
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		b2.setText("Creer Agent");
		b2.setEnabled(true);
		b2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		System.out.println("ok agent cree");
		 	}
		 });
		this.add(b2, gbc);
		
		//Parametres
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 6;
		lab3.setText("Parametres");
		lab3.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab3.setForeground(new Color(136, 66, 29));
		lab3.setPreferredSize(new Dimension(300, 100));
		lab3.setHorizontalAlignment(0);
		this.add(lab3, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 6;
		String param[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JList listparam = new JList(param);
		JScrollPane scroll = new JScrollPane(listparam);
		scroll.createVerticalScrollBar();
		this.add(scroll, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		lab4.setText("Nom");
		lab4.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		lab4.setForeground(new Color(48, 48, 48));
		//lab4.setPreferredSize(new Dimension(300, 100));
		//lab4.setHorizontalAlignment(0);
		this.add(lab4, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		saisieParam.setPreferredSize(new Dimension(100, 30));
		panParam.add(saisieParam);
		this.add(panParam, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		lab5.setText("Type");
		lab5.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		lab5.setForeground(new Color(48, 48, 48));
		//lab5.setPreferredSize(new Dimension(300, 100));
		//lab5.setHorizontalAlignment(0);
		this.add(lab5, gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		saisieType.setPreferredSize(new Dimension(100, 30));
		panType.add(saisieType);
		this.add(panType, gbc);
		gbc.gridx = 3;
		gbc.gridy = 4;
		lab6.setText("Valeur");
		lab6.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		lab6.setForeground(new Color(48, 48, 48));
		//lab6.setPreferredSize(new Dimension(300, 100));
		//lab6.setHorizontalAlignment(0);
		this.add(lab6, gbc);
		gbc.gridx = 3;
		gbc.gridy = 5;
		saisieVal.setPreferredSize(new Dimension(100, 30));
		panVal.add(saisieVal);
		this.add(panVal, gbc);
		gbc.gridx = 4;
		gbc.gridy = 4;
		lab7.setText("Minimum");
		lab7.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		lab7.setForeground(new Color(48, 48, 48));
		//lab7.setPreferredSize(new Dimension(300, 100));
		//lab7.setHorizontalAlignment(0);
		this.add(lab7, gbc);
		gbc.gridx = 4;
		gbc.gridy = 5;
		saisieMin.setPreferredSize(new Dimension(100, 30));
		panMin.add(saisieMin);
		this.add(panMin, gbc);
		gbc.gridx = 5;
		gbc.gridy = 4;
		lab8.setText("Maximum");
		lab8.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		lab8.setForeground(new Color(48, 48, 48));
		//lab8.setPreferredSize(new Dimension(300, 100));
		//lab8.setHorizontalAlignment(0);
		this.add(lab8, gbc);
		gbc.gridx = 5;
		gbc.gridy = 5;
		saisieMax.setPreferredSize(new Dimension(100, 30));
		panMax.add(saisieMax);
		this.add(panMax, gbc);
		gbc.gridx = 6;
		gbc.gridy = 4;
		lab9.setText("Maximum");
		lab9.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		lab9.setForeground(new Color(48, 48, 48));
		//lab9.setPreferredSize(new Dimension(300, 100));
		//lab9.setHorizontalAlignment(0);
		this.add(lab9, gbc);
		gbc.gridx = 6;
		gbc.gridy = 5;
		saisieInc.setPreferredSize(new Dimension(100, 30));
		panInc.add(saisieInc);
		this.add(panInc, gbc);
		
		// Bouton rechargement agents
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 6;
		b1.setText("Creer Parametre");
		b1.setEnabled(true);
		b1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		System.out.println("ok page rechargee");
		 	}
		 });
		this.add(b1, gbc);
		
		pack();
	}
}
