package fil.coo;
import quiz.answers.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TextualAnswerTest extends AnswerTest{
	protected Answer createAnswer() {
		return new TextualAnswer("test");
	}
	
	
	@Test
	public void testHasGoodType() {
		Answer answer = this.createAnswer();
		assertTrue(answer.hasGoodType("azerty"));
		assertFalse(answer.hasGoodType("2000"));
	}
}
