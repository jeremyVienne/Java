package Affichage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import quiz.answers.*;
public class MultiAnswerPanel extends AnswerPanel{
	private Answer answer;
	private String userAnswer;
	public MultiAnswerPanel(MultiAnswer answer)
	{
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
