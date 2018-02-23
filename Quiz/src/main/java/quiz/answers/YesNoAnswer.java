package quiz.answers;

import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.*;

import javafx.scene.layout.*;
import Affichage.*;
public class YesNoAnswer extends Answer<Boolean> {
	
	public YesNoAnswer(boolean answer){
		super(answer);
	}
	
	public YesNoAnswer(String answer)throws IllegalArgumentException{
		super(fromString(answer));
		if(!this.hasGoodType(answer)){
			throw new IllegalArgumentException();
		}
	}
	public String getGoodType()
	{
		return "true/false";
	}
	
	public boolean hasGoodType(String s){
		if("true".equals(s) || "false".equals(s)){
			return true;
		}
		return false;
	}
	
	private static boolean fromString(String s){
		if("true".equals(s)){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return ""+this.goodAnswer;
	}
	
	public AnswerPanel getPanel(){
		
		return AnswerPanelFactory.constructor.createYesNoPanel(this);
	}
	
	
	
}
