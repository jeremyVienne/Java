package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class FilterCFile implements FilenameFilter{
	/*
	 * It filters the files in the folder and return the file which starts with c
	 * @param dir : the Folder to check in 
	 * @param name : name of the file 
	 * @return True if the file begins with c and False if not. 
	 * */
	public boolean accept(File dir, String name) {
		return name.startsWith("C");
	}
}
