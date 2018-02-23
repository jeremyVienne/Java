package Action;
import ressource.*;
import java.util.*;
public class FreeRessourceAction<R extends Ressource>extends RessourceAction {
	
	/*
	 * Constructor of FreeRessourceAction
	 * @param pool : a RessourcePool object 
	 * @param user : a RessourceUser object
	 * @param message : a message when freeing the Ressource
	 */
	public FreeRessourceAction(RessourcePool<R> pool, RessourceUser<R> user, String message){
		super(pool,user, message);
	}
	
	@Override
	public void realStep(){
		try{
			Ressource r = this.user.getRessource();
			
			this.pool.recoverRessource(r);
			this.user.resetRessource();
			System.out.println(this.message);
		}
		catch(IllegalArgumentException e){
			System.out.println("boolean :"+ this.user.getRessource()==null);
			System.out.println(this.message + " failed");
		}
	}
	
	@Override
	public boolean stopCondition(){
		return true;
	}
	
}
