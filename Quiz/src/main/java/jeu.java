
import quiz.*;

import java.io.IOException;
public class jeu {
	public static void main(String[] args){
		
		try{

			QuestionnaireFactory factory = new QuestionnaireFactory();
			Quiz quiz = factory.createQuestionnaire("./quiz.txt");
			
			quiz.askAll(true);
		}
		catch(IOException e){
		}
		
		/*creation question*/
		/*Quiz quiz= new Quiz();
		Answer answer1= new YesNoAnswer("true");
		Answer answer2 = new TextualAnswer("Tolkien");
		Answer answer3 = new NumericalAnswer("9");
		

		Answer answer4 = new MultipleChoiceAnswer("Bill|Bourricot|Robert|Jolly");
		
		Answer answer5 = new MultiAnswer("Pippin;Sam;Frodo;Merry");
		
		
		
		Question q1 = new Question(answer1, "La terre est ronde?", 10);
		Question q2 = new Question(answer2, "Quel est le nom de l'auteur du seigneur des anneaux?",1);
		Question q3 = new Question(answer3, "Combien de membres composent la compagnie de l'anneau",2);
		Question q4 = new Question(answer4, "Comment s'appelle le poney qui accompagne la compagnie jusqu'a la Moria?",3);
		Question q5 = new Question(answer5, "Donnez le nom de l'un des hobbits de la compagnie de l'anneau:", 1);
		
		quiz.add(q1);
		quiz.add(q2);
		quiz.add(q3);
		quiz.add(q4);
		quiz.add(q5);
		quiz.askAll();*/
		
		
		
	
	}
}
