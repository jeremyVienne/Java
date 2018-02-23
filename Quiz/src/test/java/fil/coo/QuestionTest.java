package fil.coo;
import quiz.*;
import quiz.answers.Answer;
import quiz.answers.YesNoAnswer;

import org.junit.*;
import static org.junit.Assert.*;

public class QuestionTest {
	private String statement;
	private Answer answer1;
	private int pts;
	
	private Question createQuestion() {
		this.pts=10;
		this.statement= "La terre est ronde?";
		this.answer1=new YesNoAnswer("true");
		return new Question(this.answer1,this.statement, this.pts);
		
	}
	
	@Test 
	public void testQuestion() {
		Question q1= this.createQuestion();
		assertNotNull(q1);
	}
	
	@Test 
	public void testGetStatement() {
		Question q1 = this.createQuestion();
		assertEquals(this.statement, q1.getStatement());
	}
	
	@Test 
	public void testGetAnswer() {
		Question q1= this.createQuestion();
		assertEquals(this.answer1, q1.getAnswer());
	}
	
	@Test
	public void testGetPts() {
		Question q1=this.createQuestion();
		assertEquals(this.pts,q1.getPoints());
	}
}
