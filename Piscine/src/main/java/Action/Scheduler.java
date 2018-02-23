package Action;

import java.util.ArrayList;

public abstract class Scheduler extends Action {

	protected ArrayList<Action> actions;
	
	/*
	 * Constructor of a Scheduler
	 */
	public Scheduler() {
		this.setStateReady();
		this.actions = new ArrayList<Action>();
	}
	@Override
	public void realStep() {		
		Action action = this.actions.get(this.nextAction()) ;
		try {
			
			action.doStep();
		} catch (ActionFinishedException e) {
			// cannot happen since there is no finished action in a scheduler
		}
		if (action.isFinished()) this.actions.remove(action);
	}
	/*
	 * Abstract method that gives the next action for each Scheduler Action
	 */
	protected abstract int nextAction();

	/*
	 * this method adds an action in the list of actions
	 * @param action : an action to add
	 * @throws : ActionFinishedException
	 * @throws : SchedulerStardedException
	 */
	public void addAction(Action action) throws ActionFinishedException, SchedulerStardedException {
		if (this.getState() != ActionState.READY) throw new SchedulerStardedException() ;
		if (action.isFinished()) throw new ActionFinishedException() ;
		this.actions.add(action);
	}

	@Override
	public boolean stopCondition() {
		return this.actions.isEmpty();
	}
	
	/*
	 * The method returns the list of all actions in the Scheduler
	 * @return : an ArrayList that contains all the action in the Scheduler
	 */
	public ArrayList<Action> getActions(){
		return this.actions;
	}
}
