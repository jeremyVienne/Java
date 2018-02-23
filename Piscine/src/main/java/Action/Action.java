package Action;

public abstract class Action {

    protected ActionState state;
    
    /**do an action step
     * @expect ActionFinishedException
     * */
    public void doStep() throws ActionFinishedException {
        if (this.isFinished()) throw new ActionFinishedException();
        this.state = ActionState.IN_PROGRESS ;
        this.realStep() ;
        if (this.stopCondition()) this.state = ActionState.FINISHED;
    }

    /** special step for each action types
     * */
    public abstract void realStep();
    
    /** the stop condition of an action 
     * @return boolean
     * 
     * */
    public abstract boolean stopCondition();

    /** tell if the action is finished or not
     * @return boolean
     * */
    public boolean isFinished() {return this.state == ActionState.FINISHED ;}

    /** return the state (READY, IN_PROGRESS, FINISHED) of an action
     * @return ActionState
     * */
    public ActionState getState() {return this.state ;}

    /** set the state of an action to Ready
     * */
    public void setStateReady(){
    	this.state=ActionState.READY;
    }
}
