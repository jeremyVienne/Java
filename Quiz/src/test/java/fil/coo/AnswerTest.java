package fil.coo;
import quiz.answers.*;
import org.junit.*;
import static org.junit.Assert.*;

public abstract class AnswerTest {
	protected abstract Answer createAnswer();
	
	@Test 
	public void testAnswernotNull() {
		Answer a = this.createAnswer();
		assertNotNull(a);
	}
	
	@Test
	public void testIsCorrect() {
		Answer a = this.createAnswer();
		assertTrue(a.isCorrect(a.getGoodAnswer().toString()));
	}
	
	@Test
	public void testGetGoodAnswer() {
		Answer a = this.createAnswer();
		assertNotNull(a.getGoodAnswer());
	}
}
