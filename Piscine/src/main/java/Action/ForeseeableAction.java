package Action;

public class ForeseeableAction extends Action {

	private int waitingTime;
	/*
	 * Constructor of a ForeseebleAction
	 * @param waiting : an integer 
	 */
	public ForeseeableAction(int waiting) {
		this.setStateReady();
		this.waitingTime = waiting;
	}
	@Override
	public void realStep() {this.waitingTime-- ;}
	
	@Override
    public boolean stopCondition() {
        return this.waitingTime == 0;
    }	

}
