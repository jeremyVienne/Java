package Affichage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import quiz.answers.*;
public class YesNoPanel extends AnswerPanel{
	private Answer answer;
	private String userAnswer;
	public YesNoPanel(Answer answer){
		this.answer=answer;
		this.userAnswer="";
		
		
		ButtonGroup q = new ButtonGroup();
		JRadioButton bt1 = new JRadioButton("true");
		JRadioButton bt2 = new JRadioButton("false");
		q.add(bt1);
		q.add(bt2);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		this.add(bt1, BorderLayout.CENTER);
		this.add(bt2, BorderLayout.CENTER);
		
		
	
	}
	public void actionPerformed(ActionEvent e) {
		Component[] components = this.getComponents();
		
		for(Component c : components) {
			if(c.getClass().equals(JRadioButton.class)) {
				JRadioButton bt = (JRadioButton) c;
				if(bt.getText()=="true" && bt.isSelected()) {
					this.userAnswer="true";
				}
				else if (bt.getText()=="false" && bt.isSelected()) {
					this.userAnswer="false";
				}
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
