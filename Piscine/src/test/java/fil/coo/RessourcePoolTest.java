package fil.coo;
import ressource.*;
import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public abstract class RessourcePoolTest<T extends Ressource> {
	protected abstract RessourcePool<T> createRessourcePool();
	
	@Test 
	public void testRessourcePool() {
		RessourcePool<T> pool= createRessourcePool();
		assertNotNull(pool);
	}
	
	@Test
	public void testProvideRessource() {
		RessourcePool<T> pool= createRessourcePool();
		assertNotNull(pool.provideRessource());
	}
	
	@Test(expected= NoSuchElementException.class, timeout=1000)
	public void testProvideRessourceException() {
		RessourcePool<T> pool= createRessourcePool();
		while(true) {
			pool.provideRessource();
		}
	}
	
	@Test(timeout=1000)
	public void testRecoverRessource() {
		RessourcePool<T> pool= createRessourcePool();
		T ressource =pool.provideRessource();
		
		pool.recoverRessource(ressource);
		T r=pool.provideRessource();
		while(ressource!=r) {
			r=pool.provideRessource();
		}
		assertEquals(r,ressource);
	}
	
	
	@Test(expected= IllegalArgumentException.class, timeout=1000)
	public void testRecoverRessourceException() {
		RessourcePool<T> pool1= createRessourcePool();
		RessourcePool<T> pool2= createRessourcePool();
		T ressource =pool1.provideRessource();
		pool2.recoverRessource(ressource);
		
	}
	
	
}
