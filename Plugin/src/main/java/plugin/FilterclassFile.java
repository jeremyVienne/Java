package plugin;
import java.io.File;
import java.io.FilenameFilter;
public class FilterclassFile implements FilenameFilter{

	/*
	 * It filters the files in the folder and return the file which ends  with .class
	 * @param dir : the Folder to check in 
	 * @param name : name of the file  
	 * @return True if the file ends with .class and False if not. 
	 * */
	public boolean accept(File dir, String name) {
		return name.endsWith(".class") ;
	}
}
