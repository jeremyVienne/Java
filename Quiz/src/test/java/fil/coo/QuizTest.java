package fil.coo;
import quiz.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;

public class QuizTest {
	@Test
	public void testQuiz(){
		QuestionnaireFactory factory = new QuestionnaireFactory();
		try{
			Quiz q = factory.createQuestionnaire("quiz.txt");
			assertNotNull(q);
		}catch(IOException e){
			assertTrue(false);
		}
		
	}
	
	
}
