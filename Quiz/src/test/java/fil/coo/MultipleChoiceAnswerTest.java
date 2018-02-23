package fil.coo;
import quiz.answers.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceAnswerTest extends AnswerTest{
	protected Answer createAnswer() {
		List<String> answer = new ArrayList<String>();
		answer.add("1995");
		answer.add("1996");
		return new MultipleChoiceAnswer(answer);
	}
	
	
	@Test
	public void testHasGoodType() {
		Answer answer = this.createAnswer();
		assertTrue(answer.hasGoodType("1996"));
		assertFalse(answer.hasGoodType("2000"));
	}
}
