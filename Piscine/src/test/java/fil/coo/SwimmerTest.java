package fil.coo;
import Action.*;
import ressource.*;
public class SwimmerTest extends ActionTest {
	protected Action createAction() {
		return new Swimmer("test", new BasketPool(3), new CubiclePool(3), 4,4,4);
	}
}
