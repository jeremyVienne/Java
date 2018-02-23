package Action;
import ressource.*;
public abstract class RessourceAction<R extends Ressource>extends Action{
	protected RessourcePool<R> pool;
	protected RessourceUser<R> user;
	protected String message;
	
	/*
	 * Constructor of a RessourceAction
	 * @param pool : a RessourcePool object 
	 * @param user : a RessourceUser object
	 * @param message : a message to describe the action on  the Ressource
	 */
	public RessourceAction(RessourcePool<R> pool, RessourceUser<R> user, String message){
		this.setStateReady();
		this.message=message;
		this.pool=pool;
		this.user=user;
	}
	public RessourceUser<R> getUser(){
		return this.user;
	}
	
}
