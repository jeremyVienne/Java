package Affichage;
import quiz.answers.*;
public class AnswerPanelFactory{
	public static final AnswerPanelFactory constructor = new AnswerPanelFactory();
	
	private AnswerPanelFactory(){
		
	}
	
	public AnswerPanel createYesNoPanel(YesNoAnswer answer){
		return new YesNoPanel(answer);
	}
	public AnswerPanel createMultiAnswerPanel(MultiAnswer answer){
		return new MultiAnswerPanel(answer);
	}
	public AnswerPanel createMultipleChoicePanel(MultipleChoiceAnswer answer){
		return new MultipleChoicePanel(answer);
	}
	public AnswerPanel createTextualPanel(TextualAnswer answer){
		return new TextualPanel(answer);
	}
	public AnswerPanel createNumericalPanel(NumericalAnswer answer){
		return new NumericalPanel(answer);
	}

}
