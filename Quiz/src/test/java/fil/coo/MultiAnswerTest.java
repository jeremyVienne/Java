package fil.coo;
import java.util.*;
import quiz.answers.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;
public class MultiAnswerTest extends AnswerTest{
	private String goodAnswer;
	protected Answer createAnswer() {
		List<String> answer = new ArrayList<String>();
		answer.add("1995");
		answer.add("1996");
		this.goodAnswer="1996";
		return new MultiAnswer(answer);
	}
	
	@Test
	public void testIsCorrect(){
		Answer a = this.createAnswer();
		assertTrue(a.isCorrect(this.goodAnswer));
	}
}
