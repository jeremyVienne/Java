package Affichage;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import quiz.answers.*;
public class NumericalPanel extends AnswerPanel implements ChangeListener{
	private Answer answer;
	private String userAnswer;
	public NumericalPanel(NumericalAnswer answer){
		this.answer=answer;
		this.userAnswer="";
		int value = answer.getGoodAnswer();
		JSpinner number = new JSpinner();
		SpinnerModel model = new SpinnerNumberModel(value-10, value-100, value+100,1);
		model.addChangeListener(this);
		number.setModel(model);
		this.add(number);
		
	}
	public void actionPerformed(ActionEvent e) {}
	public void stateChanged(ChangeEvent e) {
		Component[] components = this.getComponents();
		for(Component c : components) {
			if(c.getClass().equals(JSpinner.class)) {
				JSpinner model= (JSpinner)c;
				this.userAnswer=""+ model.getValue();
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
