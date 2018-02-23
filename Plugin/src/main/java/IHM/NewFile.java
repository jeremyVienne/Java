package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class NewFile implements ActionListener{
	private JTextArea text;
	/*
	 * Constructor of Object NewFile
	 * @param text : a JTextArea Object
	 * */
	public NewFile(JTextArea text){
		this.text=text;
	}
	/*
	 * An action to do when a specified event given in the parameter happened
	 * @param e: An ActionEvent s
	 * */
	public void actionPerformed(ActionEvent e) {
		this.text.setText("");
	}

}
