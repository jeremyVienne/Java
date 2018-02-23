package fil.coo;
import ressource.*;
import Action.*;


public class TakeRessourceBasketTest <R> extends RessourceActionTest{
	protected TakeRessourceAction<Basket> createRessourceAction(){
		return new TakeRessourceAction<Basket>(new BasketPool(3), new RessourceUser<Basket>(), "");
	}
}
