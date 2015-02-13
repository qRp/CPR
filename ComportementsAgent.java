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
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	
	float coeff;
	JFormattedTextField saisieCoeff = new JFormattedTextField(new Float(coeff));
	JPanel panCoeff = new JPanel();
	JLabel labCoeff = new JLabel();
        JList listAg;
        JList listAg2;
    JComboBox listFix;

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
			    valide_comp(exp);
		 	}
		 });
		this.add(b1, gbc);
	

		gbc.gridx = 1;
		gbc.gridy = 5;
		b.setText("RUN");
		b.setSize(120, 20);
		b.setEnabled(true);
		b.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 
			    System.out.println("bouton run");
		 	}
		 });
		this.add(b,gbc);
		
		// Onglets
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 3;
		gbc.gridwidth = 3;
	    
		lab2.setText("Agents");
		lab2.setFont(new Font("Capitals", Font.PLAIN, 20));
		lab2.setForeground(new Color(136, 66, 29));
		lab2.setPreferredSize(new Dimension(500, 300));
		lab2.setHorizontalAlignment(0);
		pan1.add(lab2);
		String tabtemp []= new String[tableau.length];
		for(int ii=0; ii<tableau.length;ii++){
			String temp=(String)tableau[ii];
			tabtemp[ii]=temp;
		}
		listAg2 = new JList(tabtemp);
		JScrollPane scroll2 = new JScrollPane(listAg2);
		scroll2.createVerticalScrollBar();
		pan1.add(scroll2);
		String typeFix[] = {"Tête et queue", "Tête", "Indifferencie"};
		listFix = new JComboBox(typeFix);
		//		listFix.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) { 
		//		 		listFix = (JComboBox)e.getSource();// chaque element de la CB
		// 	}
		//	 });
		pan1.add(listFix);
		
		// Champs de saisie pour coefficient
		saisieCoeff.setPreferredSize(new Dimension(150, 20));
		//saisieCoeff.setAlignmentX(BOTTOM_ALIGNMENT);
		
		labCoeff.setText("Coefficient");
		labCoeff.setFont(new Font("Capitals", Font.PLAIN, 20));
		labCoeff.setForeground(new Color(136, 66, 29));
		//labCoeff.setPreferredSize(new Dimension(500, 300));
		//labCoeff.setHorizontalAlignment(0);
		//pan1.add(labCoeff);
		pan1.add(saisieCoeff);
		//pan1.add(panCoeff);
		

		lab3.setText("bonsoir");
		lab3.setPreferredSize(new Dimension(300, 100));
		pan2.add(lab3);
		
        tabpan.addTab("Onglet 1", null, pan1, "comportement de fixation");
        tabpan.addTab("Onglet 2", null, pan2, "comportement de predation TODO");
        tabpan.setTitleAt(0,"Fixation");
        tabpan.setTitleAt(1,"Predation"); 
        
        this.add(tabpan, gbc);
        
		pack();
	}
	
    public void valide_comp(Experience exp){
	Object[] tableau1=listAg.getSelectedValues();
	Object[] tableau2=listAg2.getSelectedValues();
	Agent agenttemp;
	try{
	    Parser parser = new Parser(System.getProperty("user.dir")+"/Agent.txt");
	    String temp =(String)tableau1[0];
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
	    exp.afficher();
	}
	catch(IOException e){
	    System.out.println("FATAL ERROR SYSTEM");
	}
    }

	


}


