package fil.coo;
import ressource.*;
import Action.*;

public class FreeRessourceBasketTest<R> extends RessourceActionTest {
	
	protected FreeRessourceAction<Basket> createRessourceAction(){
		BasketPool basketpool =new BasketPool(3);
		RessourceUser<Basket> basketuser= new RessourceUser<Basket>();
		TakeRessourceAction<Basket> takebasket = new TakeRessourceAction<Basket>(basketpool, basketuser, "");
		try {
			takebasket.doStep();
		}
		catch(ActionFinishedException e) {}
		return new FreeRessourceAction<Basket>(basketpool, basketuser, "");
		
	}

}
