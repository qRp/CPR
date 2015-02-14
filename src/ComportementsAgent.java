import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import java.io.*;


public class ComportementsAgent extends JFrame{

	JLabel label = new JLabel("");
	JLabel lab = new JLabel("");
	JPanel pan = new JPanel();
	
	JLabel lab1 = new JLabel("");
	JLabel lab2 = new JLabel("");
	JLabel lab3 = new JLabel("");
    JButton b = new JButton();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	
	JTabbedPane tabpan = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	//JTabbedPane tabpan = new JTabbedPane();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	float coeff;
	JFormattedTextField saisieCoeff = new JFormattedTextField(new Float(coeff));
	JPanel panCoeff = new JPanel();
	JLabel labCoeff = new JLabel();
    JList listAg;
    JList listAg2;
    JComboBox listFix;

    Experience experience;
   
    public ComportementsAgent(String titre, Object[] tableau, Experience exp1){
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
		
		Simulation expag = new Simulation(titre);
 		expag.setVisible(true);
 		String nomexp = expag.nameExp();
 		experience = new Experience(nomexp);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(new JLabel(" "), gbc);
		
		// Titre
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
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
		
		// Liste d'agents selectionnes de la page simulation
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
		String tabtemp1 []= new String[tableau.length];
		for(int i=0; i<tableau.length;i++){
			String temp1=(String)tableau[i];
			tabtemp1[i]=temp1;
		}
		listAg = new JList(tabtemp1);
		JScrollPane scroll = new JScrollPane(listAg);
		scroll.createVerticalScrollBar();
		this.add(scroll, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		b1.setText("Valider Comportement");
		b1.setEnabled(true);
		final Experience exp = exp1;		
		b1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
			    experience = valide_comp(exp);
		 	}
		 });
		this.add(b1, gbc);
	
		// Bouton RUN
		gbc.gridx = 1;
		gbc.gridy = 5;
		b.setText("RUN");
		b.setSize(120, 20);
		b.setEnabled(true);
		b.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
			    run(exp); 
		 	}
		 });
		this.add(b,gbc);
		
		// Onglets
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 3;
		gbc.gridwidth = 3;
		final Object[] tabOnglet = tableau;
		onglet1(tabOnglet);
		tabpan.addTab("Onglet 1", null, panel1, "Comportement de fixation");
        tabpan.addTab("Onglet 2", null, panel2, "Comportement de predation TODO");
        tabpan.setTitleAt(0,"Fixation");
        tabpan.setTitleAt(1,"Predation"); 
        this.add(tabpan, gbc);
		
		pack();
	}
	
   public void onglet1(Object [] tabOnglet){
	   panel1.setLayout( new GridLayout(2,3) );
	 
	   lab2.setText("Agents");
	   lab2.setFont(new Font("Capitals", Font.PLAIN, 20));
	   lab2.setForeground(new Color(136, 66, 29));
	   lab2.setHorizontalAlignment(0);
	   panel1.add(lab2, BorderLayout.WEST);
	   
	   String tabtemp []= new String[tabOnglet.length];
	   for(int ii=0; ii<tabOnglet.length;ii++){
			String temp=(String)tabOnglet[ii];
			tabtemp[ii]=temp;
	   }
	   
	   listAg2 = new JList(tabtemp);
	   JScrollPane scroll2 = new JScrollPane(listAg2);
	   scroll2.createVerticalScrollBar();
	   panel1.add(scroll2, BorderLayout.WEST);
	   String typeFix[] = {"Tete et queue", "Tete", "Indifferencie"};
	   listFix = new JComboBox(typeFix);
	   panel1.add(listFix, BorderLayout.NORTH);
	   labCoeff.setText("Coefficient :");
	   labCoeff.setFont(new Font("Capitals", Font.PLAIN, 20));
	   labCoeff.setForeground(new Color(136, 66, 29));
	   labCoeff.setHorizontalAlignment(0);
	   panel1.add(labCoeff, BorderLayout.SOUTH);
	   //saisieCoeff.setPreferredSize(new Dimension(60, 20));
	   panel1.add(saisieCoeff, BorderLayout.CENTER);
   }
    
    
    public Experience valide_comp(Experience exp){
	Object[] tableau1=listAg.getSelectedValues();
	Object[] tableau2=listAg2.getSelectedValues();
	Agent agenttemp;
	System.out.println("valide comp");
	try{
	    Parser parser = new Parser(System.getProperty("user.dir")+"/Agent.txt");
	    String temp = (String) tableau1[0];
	    Agent agent=parser.getAgent(temp);
	    ArrayList<Agent> lagent = new ArrayList<Agent>();
	    for(int iv=0; iv<tableau2.length;iv++){
	    	String tempiv=(String)tableau2[iv];
	    	agenttemp=parser.getAgent(tempiv);
	    	lagent.add(agenttemp);
	    }
	    String type =(String)listFix.getSelectedItem();
	  
	    coeff = new Float(saisieCoeff.getText()).floatValue();	    
	    System.out.println(coeff);
	    Process process = new Fixation("fixation",agent,lagent,type,coeff);
	    exp.add_process(process);
	    return exp;
	}
	catch(IOException e){
	    System.out.println("FATAL ERROR SYSTEM - ComportementsAgent.java");
	    return null;
	}
    }


	public void run(Experience exp){
        Environnement test = exp.getenvironnement();
        System.out.println("test emi "+test);
	    SaveNetlogo snl = new SaveNetlogo(exp);
	    String nameFile = snl.writeFile();
	    RunNetlogo runNL = new RunNetlogo(nameFile);
	    runNL.run();
	    //TODO Connecter la partie netLogo avec exp
	}


}


