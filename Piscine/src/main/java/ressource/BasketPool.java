
package ressource;

public class BasketPool extends RessourcePool<Basket>{
	public BasketPool(int n){
		 super(n); 
	}
	protected Basket createRessource(){
		return new Basket();
	}
	
	
}
