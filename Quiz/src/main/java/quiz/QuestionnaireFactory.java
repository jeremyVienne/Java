package quiz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import quiz.answers.*;
public class QuestionnaireFactory {
	
	public QuestionnaireFactory(){}
	
	public Question createQuestion(String text , String answer, String points)throws IOException{
		try
		{
			int	nbPoints = Integer.parseInt(points );
			return  new	Question(AnswerFactory.FACTORY.build(answer) ,text, nbPoints);
		}
		catch(NumberFormatException e)
		{
			throw new IOException("bad format");
		}
	}
	
	public Quiz createQuestionnaire(String fileName) throws IOException{
		Quiz questionnaire =new Quiz ();
		File source =new File (fileName);
		BufferedReader in =	null;
		try{
			in =new	BufferedReader(new FileReader(source ));
			String text ;
			// read block of 3 lines : text , answer and number of points
			while((text = in . readLine())!=null){
				
				String answer = in.readLine ();
				String nbPoints = in.readLine ();
				if(answer ==null ||	nbPoints ==null){
					throw new IOException("bad format");
				}
				questionnaire.add(this.createQuestion(text, answer, nbPoints));
			}
		}
		catch(FileNotFoundException e){
			throw new IOException(e);
		}
		finally{
			in.close ();
		}
		return questionnaire ;
		}
	
	
}
