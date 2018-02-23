package fil.coo;
import ressource.*;
public class CubiclePoolTest extends RessourcePoolTest<Cubicle>{
	protected  RessourcePool<Cubicle> createRessourcePool(){
		return new CubiclePool(3);
	}
}
