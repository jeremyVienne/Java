package quiz.answers;
import java.util.*;
import Affichage.*;

import javax.swing.JPanel;
public class NumericalAnswer extends Answer<Integer>{
	public NumericalAnswer(int i){
		super(i);
	}
	public NumericalAnswer(String s)throws IllegalArgumentException{
		super(fromString(s));
		if(!this.hasGoodType(s)){
			throw new IllegalArgumentException();
		}
	}
	
	public String getGoodType()
	{
		return "numerique";
	}
	
	public boolean hasGoodType(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
	
	private static int fromString(String s){
		return Integer.parseInt(s);
	}
	
	public AnswerPanel getPanel(){
		return AnswerPanelFactory.constructor.createNumericalPanel(this);
	}
}
