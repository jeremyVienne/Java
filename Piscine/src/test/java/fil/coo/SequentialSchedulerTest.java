package fil.coo;
import Action.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SequentialSchedulerTest extends SchedulerTest {

	@Override
	protected Scheduler createScheduler() {
		return new SequentialScheduler() ;
	}
	
	@Test
	public void sequentialSchedulerOK() throws ActionFinishedException, SchedulerStardedException{
		Scheduler scheduler = this.createScheduler() ;
		for (int i = 0 ; i < 2 ; i++) scheduler.addAction(new TwoStepAction()) ;
		for (int i = 0 ; i < 2 ; i++)  scheduler.doStep() ; 
		assertEquals(scheduler.getActions().size(), 1) ;
	}


}
