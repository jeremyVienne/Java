package ressource;
import java.util.*;
public abstract class RessourcePool<T extends Ressource>{
	private List<T> free;
	private List<T> used;
	
	public RessourcePool(int n){
		this.free = new ArrayList<T>(n);
		this.used = new ArrayList<T>(n);
		
		for(int i=0 ; i < n ; i++)
		{
			this.free.add(this.createRessource());
		}
	}
	
	/**give  a free ressource (T type) 
	 * @return T RessourcePool
	 * @exception NoSuchElementException
	 * */
	public T provideRessource() throws NoSuchElementException{
		if(!this.free.isEmpty()){
			T retour = this.free.remove(0);
			this.used.add(retour);
			
			return retour;
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	/** recover used ressource to free ressource
	 * @param T ressource
	 * @exception IllegalArgumentException
	 * */
	public void recoverRessource(T ressource)throws IllegalArgumentException{
		if(this.used.contains(ressource)){
			this.free.add(this.used.remove(this.used.indexOf(ressource)));
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	/** create pool for each ressources 
	 * @return T RessourcePool
	 * */
	protected abstract T createRessource();
}
