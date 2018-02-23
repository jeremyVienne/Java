package quiz.answers;

import java.util.*;
import Affichage.*;

import javax.swing.JPanel;

import Affichage.AnswerPanelFactory;
public class MultipleChoiceAnswer extends TextualAnswer{
	private List<String> choice;
	
	public MultipleChoiceAnswer(List<String> s){
		super(s.get(0));
		this.choice=s;
	}
	
	public MultipleChoiceAnswer(String s)throws IllegalArgumentException{
		super(fromString(s).get(0));
		
		if(!s.contains("|")){
			throw new IllegalArgumentException();
		}
		
		this.choice=fromString(s);
	}
	public String getGoodType()
	{
		return this.choice.toString();
	}
	
	public boolean hasGoodType(String s){
		return this.choice.contains(s);
	}
	public static List<String> fromString(String s){
		String[] answers = s.split("\\|");
		return new ArrayList<String>(Arrays.asList(answers));
	}
	
	public AnswerPanel getPanel(){
		return AnswerPanelFactory.constructor.createMultipleChoicePanel(this);
	}
}
