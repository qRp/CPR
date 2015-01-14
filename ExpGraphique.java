import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ExpGraphique extends JFrame {
	JLabel label = new JLabel("");
	JLabel label1 = new JLabel("");
	JLabel label2 = new JLabel("");
	JLabel label3 = new JLabel("");
	JLabel label4 = new JLabel("");

	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();

	public ExpGraphique(String titre) {
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
		label.setText(titre);
		this.add(label, gbc);
		
		// Visualisation résultats
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		label1.setText("Resultats");
		label1.setForeground(Color.blue);
		label1.setPreferredSize(new Dimension(100, 100));
		label1.setHorizontalAlignment(0);
		this.add(label1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		b1.setText("Visualiser");
		b1.setEnabled(true);
		b1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		System.out.println("visu");
		 	}
		 });
		this.add(b1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		String c1[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JList list1 = new JList(c1);
		JScrollPane scroll = new JScrollPane(list1);
		scroll.createVerticalScrollBar();
		this.add(scroll, gbc);
		
		// Environnement
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		label2.setText("Environnement");
		label2.setForeground(Color.blue);
		label2.setPreferredSize(new Dimension(100, 100));
		label2.setHorizontalAlignment(0);
		this.add(label2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		b2.setText("Creer");
		b2.setEnabled(true);
		b2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		System.out.println("creer");
		 	}
		 });
		this.add(b2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		String c2[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JList list2 = new JList(c2);
		JScrollPane scroll2 = new JScrollPane(list2);
		scroll2.createVerticalScrollBar();
		this.add(scroll2, gbc);

		// Agents
		/*gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		label3.setText("Agents");
		label3.setForeground(Color.blue);
		label3.setPreferredSize(new Dimension(100, 100));
		label3.setHorizontalAlignment(0);
		this.add(label3, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		b3.setText("Creer");
		b3.setEnabled(true);
		b3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		System.out.println("creer");
		 	}
		 });
		this.add(b3, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		String c3[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JList list3 = new JList(c3);
		this.add(list3, gbc);*/

		// Comportements
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		label4.setText("Comportements");
		label4.setForeground(Color.blue);
		label4.setPreferredSize(new Dimension(100, 100));
		label4.setHorizontalAlignment(0);
		this.add(label4, gbc);
		gbc.gridx = 4;
		gbc.gridy = 3;
		b4.setText("Creer");
		b4.setEnabled(true);
		b4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		System.out.println("creer");
		 	}
		 });
		this.add(b4, gbc);
		gbc.gridx = 4;
		gbc.gridy = 4;
		String c4[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JList list4 = new JList(c4);
		JScrollPane scroll3 = new JScrollPane(list4);
		scroll3.createVerticalScrollBar();
		this.add(scroll3, gbc);

		//Ligne vide
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridheight = 1; //nb lignes
		gbc.gridwidth = 1; //nb colonnes
		this.add(new JLabel(" "), gbc);
		System.out.println("test");
		pack();
		
	}
}
