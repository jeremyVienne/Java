package Affichage;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
public class Fenetre extends JFrame{
	

	
	public Fenetre() {
		super();

		
		affichage();
	}
	
	private void affichage() {
		//Set Title
		this.setTitle("QUIZ!!!");
		
		//set Layout of the content panel
		this.setLayout(new BorderLayout());
				
		// taille de la  fenetre
		this.setSize(600, 600);		
		this.setPreferredSize(new Dimension(605,437));
		this.setMaximumSize(new Dimension(605,437));
		this.setMinimumSize(new Dimension(605,437));
		this.setResizable(false);
		//positionne au centre
		this.setLocationRelativeTo(null);
		
		// termine le processus si l'on ferme l'appli
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		
		// rend la fenetre visible
		this.setVisible(true);
	}
	
}
	
	


