package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OpenFile implements ActionListener{
	private JTextArea text;
	/*
	 * Constructor of OpenFile Object 
	 * @param text : a JtextArea Object
	 * */
	public OpenFile(JTextArea text){
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
        if (chooser.showOpenDialog(frame) == JFileChooser.OPEN_DIALOG) {
        	 
                 File file = chooser.getSelectedFile();
                 FileInputStream fis;
				try {
					fis = new FileInputStream(file);
					 byte[] data = new byte[(int) file.length()];
	                 fis.read(data);
	                 fis.close();

	                 str = new String(data, "UTF-8");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JFrame f = new JFrame();
					JPanel panel = new JPanel();
					JLabel label = new JLabel("Impossible d'ouvrir le fichier!");
					panel.add(label);
					f.add(panel);
					f.setSize(220, 100);
					f.setLocationRelativeTo(null);
					f.setVisible(true);
					
				}
                
				this.text.setText(str);
             

        } else {
            // do when cancel
        }
        
        
	}

}
