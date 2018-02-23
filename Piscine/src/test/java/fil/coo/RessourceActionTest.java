package fil.coo;
import Action.*;
import ressource.Ressource;
public abstract class RessourceActionTest<R extends Ressource> extends ActionTest{
	
	protected abstract RessourceAction<R> createRessourceAction();
	protected RessourceAction<R> createAction() {
		return createRessourceAction();
	}
	
}
