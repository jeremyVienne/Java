package fil.coo;
import org.junit.*;
import static org.junit.Assert.*;
import plugin.*;
import java.io.*;
import IHM.*;
public class FileCheckerTest {
	private FilenameFilter filter;
	private FileChecker file;
	@Before
	public void before(){
		Fenetre frame=null;
		this.filter=null;
		//this.file= new FileChecker(this.filter, "./repository/plugins", frame);
	}
	@Test
	public void TestCreateFileChecker(){
		//assertNotNull(new FileChecker(null, "./repository/plugins", null));		
	}
	@Test
	public void TestaddFileListener(){
		/*int taille = this.file.getListener().size();
		this.file.addFileListener(new Listener());
		assertTrue(this.file.getListener().size()==(taille+1));*/
	}
	
	@Test
	public void TestremoveFileListener(){
		
		/*Listener d = new Listener();
		this.file.addFileListener(d);
		int taille = this.file.getListener().size();
		this.file.removeFileListener(d);
		assertTrue(this.file.getListener().size()==(taille-1));*/
	}
	
}