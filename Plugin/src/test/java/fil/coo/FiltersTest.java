package fil.coo;
import org.junit.*;
import static org.junit.Assert.*;
import plugin.*;
public class FiltersTest {

	@Test 
	public void testFilterCFile(){
		FilterCFile f = new FilterCFile();
		assertTrue(f.accept(null, "C"));
		assertFalse(f.accept(null, "A"));
		
	}
	
	@Test
	public void testFilterClassFile(){
		FilterclassFile f = new FilterclassFile();
		assertTrue(f.accept(null, ".class"));
		assertFalse(f.accept(null, ".txt"));
	}
	
	@Test
	public void testPluginFilter(){
		PluginFilter f = new PluginFilter();
		assertFalse(f.accept(null, ""));
	}
	
	
}
