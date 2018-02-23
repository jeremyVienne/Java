package Action;
import ressource.*;
import java.util.*;

public class TakeRessourceAction<R extends Ressource>extends RessourceAction{
	private boolean done;
	/*
	 * Constructor of a TakeRessourceAction
	 * @param pool : a RessourcePool object 
	 * @param user : a RessourceUser object
	 * @param message : a message when taking the Ressource
	 */
	public TakeRessourceAction(RessourcePool<R> pool, RessourceUser<R> user, String message){
		super(pool,user, message);
		this.done=false;
	}
	/*
	 * (non-Javadoc)
	 * @see Action.Action#realStep()
	 */
	public void realStep(){
		try{
			
			Ressource r = this.pool.provideRessource();

			this.user.setRessource(r);
			System.out.println(this.message +" success");
			this.done=true;
		}
		catch(NoSuchElementException e){
			System.out.println(this.message +" failed");
		}
	}
	/*
	 * (non-Javadoc)
	 * @see Action.Action#stopCondition()
	 */
	public boolean stopCondition(){
		return this.done;
	}
}
