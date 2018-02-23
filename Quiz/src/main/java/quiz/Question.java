package quiz;
import quiz.answers.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
public class Question {
	private Answer<?> answer;
	private String statement;
	private int points;
	
	public Question(Answer<?> a, String statement, int p){
		this.answer=a;
		this.statement=statement;
		this.points=p;
	}
	
	public Answer<?> getAnswer(){
		return this.answer;
	}
	
	public String getStatement(){
		return this.statement;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public JPanel getQuestionPanel(){
		JPanel question = new JPanel();
		question.setMinimumSize(new Dimension(600,70));
		question.setPreferredSize(new Dimension(600,70));
		
		JLabel label = new JLabel(this.statement);
		
		question.add(label, BorderLayout.WEST);
		question.setLayout(new BoxLayout(question, BoxLayout.Y_AXIS));
		question.add(this.answer.getPanel(), BorderLayout.WEST);
		question.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		return question;
	}
}
