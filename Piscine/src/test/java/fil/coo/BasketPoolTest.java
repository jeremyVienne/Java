package fil.coo;
import ressource.*;
public class BasketPoolTest extends RessourcePoolTest<Basket>{
	protected  RessourcePool<Basket> createRessourcePool(){
		return new BasketPool(3);
	}
}
