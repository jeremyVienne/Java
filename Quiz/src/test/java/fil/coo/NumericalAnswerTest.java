package fil.coo;
import quiz.answers.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NumericalAnswerTest extends AnswerTest{
	protected Answer createAnswer() {
		return new NumericalAnswer(1995);
	}
	
	
	@Test
	public void testHasGoodType() {
		Answer answer = this.createAnswer();
		assertTrue(answer.hasGoodType("1995"));
		assertFalse(answer.hasGoodType("azezrty"));
	}
}
