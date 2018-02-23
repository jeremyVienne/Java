package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileEvent extends java.util.EventObject {
	private String file_name;
	/*
	 * Constructor of the FileEvent
	 * @param name : name of the file  
	 * */
	public FileEvent(String name){
		super(name);
		this.file_name=name;
		
	}
	/*
	 * A getter of the Name of the File added or removed 
	 * @return String Object
	 * */
	public String getfile_name(){
		return this.file_name;
	}
	
	
}
