package plugin;

import java.util.*;
import java.io.FilenameFilter;

import javax.swing.Timer;

import IHM.Fenetre;

public class FileChecker{
	private static final int FREC=1000;
	private ArrayList <FileListener> listeners = new ArrayList<FileListener>();
	private Fenetre fenetre;
	/*
	 * Constructor of the Object FileChecker 
	 * @param f : FilenamFilter Object
	 * @param path : the path  of the Folder to check
	 * @param fenetre : the IHM Object 
	 * */
	public FileChecker(FilenameFilter f, String path, Fenetre fenetre){
		this.fenetre=fenetre;
		new Timer(FREC, new FileUpdate(this,f, path)).start();
		
	} 
	/*
	 * A getter of the FileListener 's List
	 * @return List<FileListener>
	 * */
	public List<FileListener> getListener(){
		return this.listeners;
	}
	
	/*
	 * Method which deals with action to do when a  file is added
	 * @param file : A FileEvent
	 * */
	public void fireFileAdded(FileEvent file){
		ArrayList<FileListener> l = (ArrayList<FileListener>) listeners.clone();
		if(l.size()==0)return;
		for(FileListener f : l){
			f.fileAdded(file);
		}		
	}
	/*
	 * Method which deals with action to do when a  file is removed
	 * @param file : a FileEvent Object 
	 * */
	public void fireFileRemoved(FileEvent file){
		ArrayList<FileListener> l =(ArrayList<FileListener>)listeners.clone();
		if(l.size()==0)return;
		for(FileListener f : l){
			f.fileRemoved(file);
		}		
	}
	
	/*
	 * It adds a FileListener in The FileListener 's List
	 * @param f : a FileListener Object
	 * */
	public void addFileListener(FileListener f){
		if(listeners.contains(f)){return;}
		listeners.add(f);
		
	}
	
	/*
	 * It removes  a FileListener in The FileListener 's List
	 * @param f : a FileListener Object
	 * */
	public void removeFileListener(FileListener f){
		if(!listeners.contains(f)){return;}
		listeners.remove(f);
	}
	
	/*
	 * A getter of the IHM 
	 * @return Fenetre Object
	 * */
	public Fenetre getFenetre(){
		return this.fenetre;
	}
}
