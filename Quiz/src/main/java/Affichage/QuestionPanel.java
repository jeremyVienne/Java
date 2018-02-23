package Affichage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quiz.answers.Answer;
import quiz.*;
public class QuestionPanel extends JPanel{
	private Question q;
	private AnswerPanel answser;
	public QuestionPanel(Question q){
		super();
		this.q=q;
		this.answser=q.getAnswer().getPanel();
		
		
		
	}
	
	public JPanel qPanel() {
		this.setMinimumSize(new Dimension(600,100));
		this.setPreferredSize(new Dimension(600,100));
		this.setMaximumSize(new Dimension(600,100));
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel label = new JLabel(this.q.getStatement());
		JPanel panel= new JPanel();
		panel.add(label);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setPreferredSize(new Dimension(600,50));
		panel.setMaximumSize(new Dimension(600,50));
		this.add(panel);
		label.setLocation(0, 0);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(this.answser);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return this;
	}
	
	public Question getQuestion() {
		return this.q;
	}
	public JPanel getAnswerPanel() {
		return this.answser;
	}
}
