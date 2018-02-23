package Action;

public class FairScheduler extends Scheduler {

	protected int currentIndex;
	
	public FairScheduler() {
		this.currentIndex = 0;
	}

	@Override
	protected int nextAction() {
		int index = this.currentIndex ;
		this.currentIndex++ ;
		return index % this.actions.size();
		
	}

}
