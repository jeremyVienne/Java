package quiz.answers;

import javax.swing.JPanel;
import Affichage.*;
public abstract class Answer<T> {
	protected T goodAnswer;
	
	/*Abstract0*/
	public abstract String getGoodType();
	public abstract boolean hasGoodType(String s);
	public abstract AnswerPanel getPanel();
	
	/*Method*/
	public Answer(T good){
		this.goodAnswer=good;
	}
	
	public boolean isCorrect(String s){
		return (""+this.goodAnswer).equals(s);
	}
	
	public T getGoodAnswer(){
		return this.goodAnswer;
	}
	
	public String toString(){
		return ""+this.goodAnswer;
	}
	
}
