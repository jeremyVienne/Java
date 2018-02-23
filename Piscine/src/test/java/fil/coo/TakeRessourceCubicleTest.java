package fil.coo;

import ressource.*;
import Action.*;

public class TakeRessourceCubicleTest<R> extends RessourceActionTest{
	
	protected TakeRessourceAction<Cubicle> createRessourceAction(){
		return new TakeRessourceAction<Cubicle>(new CubiclePool(3), new RessourceUser<Cubicle>(), "");
	}

}
