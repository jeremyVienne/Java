package fil.coo;
import Action.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class ForeseeableActionTest extends ActionTest {

	@Override
	protected Action createAction() {
		return new ForeseeableAction(3) ;
	}
	
	@Test
	public void aForeseeableActionHasAFixedNumberOfSteps()throws ActionFinishedException {
		int n = (int) (Math.random() * 100) + 1 ;
		Action action = new ForeseeableAction(n) ;
		for (int i = 0 ; i < n ; i++) action.doStep() ;
		assertTrue(action.isFinished()) ;
	}

}
