package quiz.answers;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Affichage.*;
public class TextualAnswer extends Answer<String>{
	public TextualAnswer(String s){
		super(s);
	}
	
	public String getGoodType()
	{
		return "symbolique";
	}
	
	public boolean hasGoodType(String s){
		try{
			Integer.parseInt(s);
			return false;
		}
		catch(NumberFormatException e){
			return true;
		}
	}
	
	public AnswerPanel getPanel(){
		 return AnswerPanelFactory.constructor.createTextualPanel(this);
	}
	
}
