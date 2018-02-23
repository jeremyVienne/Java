package quiz.answers;
import java.util.*;
import Affichage.*;
import javax.swing.*;
public class MultiAnswer extends Answer<List<String>>{

	
	public MultiAnswer(List<String> s){
		super(s);
	}
	
	public MultiAnswer(String[] s){
		super(new ArrayList<String>(Arrays.asList(s)));
	}
	public MultiAnswer(String s)throws IllegalArgumentException{

		super(fromString(s));
		if(!s.contains(";")){
			throw new IllegalArgumentException("bad format");
		}
	}
	public String getGoodType()
	{
		return this.getGoodAnswer().size() + " reponses possibles";
	}
	
	public boolean hasGoodType(String s){
		return true;
	}
	
	public boolean isCorrect(String s){
		return this.goodAnswer.contains(s);
	}
	
	
	private static List<String> fromString(String s){
		String[] answers = s.split(";");
		return new ArrayList<String>(Arrays.asList(answers));
	}
	
	public AnswerPanel getPanel(){
		return AnswerPanelFactory.constructor.createMultiAnswerPanel(this);
	}
}
