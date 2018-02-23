package fil.coo;
import Action.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FairSchedulerTest extends SchedulerTest {

	@Override
	protected Scheduler createScheduler() {
		return new FairScheduler() ;
	}
	
	@Test
	public void fairSchedulerOK() {
		Scheduler scheduler = this.createScheduler();
		try{
			for (int i = 0 ; i < 2 ; i++) scheduler.addAction(new TwoStepAction()) ;
			for (int i = 0 ; i < 2 ; i++)  scheduler.doStep() ; 
			assertEquals(scheduler.getActions().size(), 2) ;
		}
		catch(ActionFinishedException e){}
		catch(SchedulerStardedException e){}
	}


}
