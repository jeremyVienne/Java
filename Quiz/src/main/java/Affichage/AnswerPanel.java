package Affichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import quiz.answers.Answer;

public abstract class AnswerPanel extends JPanel implements ActionListener{
	public AnswerPanel(){
		
	}
	
	public abstract String getUserAnswer();
	public abstract Answer getAnswer();
	public abstract void actionPerformed(ActionEvent e);
}
