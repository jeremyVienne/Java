package fil.coo;
import quiz.answers.*;
import org.junit.*;
import static org.junit.Assert.*;

public class YesNoAnswerTest extends AnswerTest{
	protected Answer createAnswer() {
		return new YesNoAnswer("true");
	}
	
	
	@Test
	public void testHasGoodType() {
		Answer answer = this.createAnswer();
		assertTrue(answer.hasGoodType("true"));
		assertFalse(answer.hasGoodType("test"));
	}
}
