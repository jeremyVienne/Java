package fil.coo;
import Action.*;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ActionTest {
	
	protected abstract Action createAction() ;
	
	@Test
	public void newActionIsInReadyState() {
		Action action = this.createAction() ;
		assertEquals(action.getState() , ActionState.READY) ;
	}
	
	@Test(timeout=1000)
	public void finishedImpliesStopCondition() {
		Action action = this.createAction() ;
		try{
			while (! action.isFinished()) action.doStep() ;
			assertTrue(action.stopCondition()) ;
		}catch(ActionFinishedException e){
			
		}
		
	}
	
	@Test(expected=ActionFinishedException.class, timeout=1000)
	public void finishedActionCannotContinue() throws ActionFinishedException{
		
			Action action = this.createAction() ;
			while (!action.isFinished()) {action.doStep() ;}
			action.doStep();
	}
}
