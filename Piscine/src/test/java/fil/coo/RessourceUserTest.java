package fil.coo;
import ressource.*;
import static org.junit.Assert.*;
import org.junit.Test;
public abstract class RessourceUserTest {
	protected abstract Ressource createRessource();
	
	@Test
	public void testSetGetRessource() {
		Ressource ressource= createRessource();
		RessourceUser user = new RessourceUser();
		
		user.setRessource(ressource);
		assertEquals(user.getRessource(), ressource);
	}
	
	@Test
	public void testResetRessource() {
		Ressource ressource= createRessource();
		RessourceUser user = new RessourceUser();
		user.setRessource(ressource);
		user.resetRessource();
		assertEquals(user.getRessource(), null);
	}
	

}
