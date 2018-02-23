package Affichage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import quiz.answers.*;
public class TextualPanel extends AnswerPanel{
	private Answer answer;
	private String userAnswer;
	public TextualPanel(TextualAnswer answer){
		this.answer=answer;
		this.userAnswer="";
		JTextField text = new JTextField();
		text.addActionListener(this);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));	
		text.setBounds(5, 5, 200, 50);
		text.setSize(200, 50);
		text.setMaximumSize(new Dimension(400,100));
		text.setPreferredSize(new Dimension(200,50));
		this.add(text);

	}
	public void actionPerformed(ActionEvent e) {
		Component[] components = this.getComponents();
		
		for(Component c : components) {
			if (c.getClass().equals(JTextField.class)) {
				JTextField text = (JTextField) c;
				this.userAnswer=text.getText();
			}
		}
		
		
	}
	
	public String getUserAnswer() {
		return this.userAnswer;
	}
	
	public Answer getAnswer() {
		return this.answer;
	}
}
