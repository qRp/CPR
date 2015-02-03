import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class AgentGraphique extends JFrame {
	
	JLabel label = new JLabel("");
	
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
		label.setText("Agents");
		this.add(label, gbc);
	}
}
