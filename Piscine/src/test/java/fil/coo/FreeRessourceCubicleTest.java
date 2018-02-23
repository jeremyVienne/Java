package fil.coo;
import ressource.*;
import Action.*;


public class FreeRessourceCubicleTest<R> extends RessourceActionTest {
	
	protected FreeRessourceAction<Cubicle> createRessourceAction(){
		CubiclePool cubiclepool =new CubiclePool(3);
		RessourceUser<Cubicle> cubicleuser= new RessourceUser<Cubicle>();
		TakeRessourceAction<Cubicle> takecubicle = new TakeRessourceAction<Cubicle>(cubiclepool, cubicleuser, "");
		try {
			takecubicle.doStep();
		}
		catch(ActionFinishedException e) {}
		return new FreeRessourceAction<Cubicle>(cubiclepool, cubicleuser, "");
		
	}

}
