package fil.coo;
import ressource.*;
public class BasketRessourceTest extends RessourceUserTest{
	@Override
	protected Basket createRessource() {
		return new Basket();
	}
}
