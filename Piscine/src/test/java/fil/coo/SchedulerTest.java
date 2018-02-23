package fil.coo;
import Action.*;
import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class SchedulerTest{
	
	protected abstract Scheduler createScheduler() ;
	
	protected class TwoStepAction extends Action {
		
		private int step = 0 ;

		@Override
		public void realStep() {this.step++ ;}

		@Override
		public boolean stopCondition() {return this.step == 2 ;}		
	}
	
	@Test
	public void addActionOK() throws ActionFinishedException, SchedulerStardedException{
		Scheduler scheduler = this.createScheduler() ;
		assertEquals(scheduler.getActions().size() , 0) ;
		scheduler.addAction(new TwoStepAction());
		assertEquals(scheduler.getActions().size() , 1) ;
	}
	
	@Test(expected = SchedulerStardedException.class)
	public void addActionWhenSchedulerHasStartedNotOK()throws SchedulerStardedException, ActionFinishedException{
		Scheduler scheduler = this.createScheduler() ;
		scheduler.addAction(new TwoStepAction()) ;
		scheduler.doStep() ;
		scheduler.addAction(new TwoStepAction()) ;
	}
		
	@Test(expected = ActionFinishedException.class)
	public void addFinishedActionNotOK()throws ActionFinishedException,SchedulerStardedException{
		Scheduler scheduler = this.createScheduler() ;
		Action action = new TwoStepAction() ;
		action.doStep() ; action.doStep() ;
		scheduler.addAction(action);
		
	}
	
	@Test
	public void aFinishedSchedulerDoesNotContainAnyNonFinishedAction() throws ActionFinishedException, SchedulerStardedException{
		Scheduler scheduler = this.createScheduler() ;
		for (int i = 0 ; i < 3 ; i++) scheduler.addAction(new TwoStepAction()) ;
		for (int i = 0 ; i < 3 ; i++) {scheduler.doStep() ; scheduler.doStep(); }
		assertTrue(scheduler.isFinished()) ;
		for (Action a : scheduler.getActions()) assertFalse(a.isFinished()) ;
	}
	
	

}
