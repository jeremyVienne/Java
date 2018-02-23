package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SaveFile implements ActionListener{
	private JTextArea text;
	/*
	 * Constructor of OpenFile Object 
	 * @param text : a JtextArea Object
	 * */
	public SaveFile(JTextArea text){
		this.text=text;
	}
	
	/*
	 * Action to do when the action in parameter happened
	 * @param e : an ActionEvent Object
	 * */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JFileChooser chooser = new JFileChooser();
		String str= "";
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setSelectedFile(new File(""));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // chooser.setAcceptAllFileFilterUsed(false);
        int res = chooser.showSaveDialog(frame);
        if (res== JFileChooser.APPROVE_OPTION) {
        	 	
                 File file = chooser.getSelectedFile();
                 FileInputStream fis;
                 try {
					PrintWriter writer = new PrintWriter(file.getName());
					writer.print(this.text.getText());
					writer.close();
				} catch (FileNotFoundException e1) {
					JFrame f = new JFrame();
					JPanel panel = new JPanel();
					JLabel label = new JLabel("Impossible d'enregistrer le fichier!");
					panel.add(label);
					f.add(panel);
					f.setSize(300, 100);
					f.setLocationRelativeTo(null);
					f.setVisible(true);
				}
                 
                
				this.text.setText(str);
             

        } else {
            // do when cancel
        }
        
        
	}

}
