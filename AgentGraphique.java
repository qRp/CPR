import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class AgentGraphique extends JFrame {
	
	JLabel label = new JLabel("");
	JLabel lab = new JLabel("");
	JPanel pan = new JPanel();
	
	public AgentGraphique(String titre) {
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
		
		pack();
	}
}
