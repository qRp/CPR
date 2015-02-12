import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class ComportementsAgent extends JFrame{
	
	JLabel label = new JLabel("");
	JLabel lab = new JLabel("");
	JPanel pan = new JPanel();
	
	JLabel lab1 = new JLabel("");
	JLabel lab2 = new JLabel("");
	JLabel lab3 = new JLabel("");
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	
	//JTabbedPane tabpan = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	JTabbedPane tabpan = new JTabbedPane(SwingConstants.TOP);
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();

	public ComportementsAgent(String titre) {
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
		gbc.gridwidth = 3;
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
		
		// Liste d'agents
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		lab1.setText("Agents");
		lab1.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab1.setForeground(new Color(136, 66, 29));
		lab1.setPreferredSize(new Dimension(300, 100));
		lab1.setHorizontalAlignment(0);
		this.add(lab1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		String tab[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JList listAg = new JList(tab);
		JScrollPane scroll = new JScrollPane(listAg);
		scroll.createVerticalScrollBar();
		//scroll.addActionListener(new ActionListener() {
		 //	public void actionPerformed(ActionEvent e) { 
		 //		agentsListe();
		 //	}
		 //});
		this.add(scroll, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		b1.setText("ok");
		b1.setEnabled(true);
		b1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
		 		System.out.println("ok agent selectionne");
		 	}
		 });
		this.add(b1, gbc);
		
		
		// Onglets
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 3;
		gbc.gridwidth = 2;

		pan1.setBackground(Color.blue);
		lab2.setText("bonjour");
		lab2.setPreferredSize(new Dimension(300, 100));
		
		pan1.add(lab2);
		pan1.add(b1);
		
		pan2.setBackground(Color.yellow);
		lab3.setText("bonsoir");
		lab3.setPreferredSize(new Dimension(300, 100));
		pan2.add(lab3);
		
        tabpan.addTab("Onglet 1", null, pan1, "description contenu 1");
        tabpan.addTab("Onglet 2", null, pan2, "description contenu 2");
        tabpan.setTitleAt(0,"Fixation");
        tabpan.setTitleAt(1,"Predation"); 
        
        this.add(tabpan, gbc);
        
		pack();
	}
	
	
	public void agentsListe(){
		System.out.println("liste d'agents");
	}
}
