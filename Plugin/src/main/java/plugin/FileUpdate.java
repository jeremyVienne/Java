package plugin;


import java.io.File;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.FilenameFilter;
public class FileUpdate implements ActionListener {
	private ArrayList<String> old = new ArrayList<String>();
	private FilenameFilter f;
	private FileChecker check;
	private String path;
	/*
	 * Constructor of the FileUpdate Object
	 * @param c : FileChecker Object 
	 * @param f : FilenameFilter Object which specifies how to filter the file in the folder to check
	 * @param path : String to specify the path of the folder to check  
	 * */
	public FileUpdate(FileChecker c,FilenameFilter f, String path){
		this.f=f;
		this.path=path;
		this.check = c;
		Listener d = new Listener();
		UpdatePluginListener u = new UpdatePluginListener(this.check.getFenetre()); 
		this.check.addFileListener(u);
		this.check.addFileListener(d);
		File file = new File(path);
		
		String[] t = file.list(f);
		for(int inc=0; inc<t.length;inc++){
			FileEvent e = new FileEvent(t[inc]);
			
			this.check.fireFileAdded(e);
			old.add(t[inc]);
		}
	}
	/**
	 * It detects  the files added or removed in the folder 
	 * @param event : an ActionEvent 
	 * */
	public void actionPerformed(ActionEvent event) {
		File file = new File(this.path);
		String[] tab = file.list(this.f);
		ArrayList<String> now= new ArrayList<String>();
		ArrayList<String> ol= (ArrayList<String>) old.clone();
		for(int inc=0; inc< tab.length;inc++){
			if(!ol.contains(tab[inc])){
				FileEvent c = new FileEvent(tab[inc]);
				this.check.fireFileAdded(c);
				old.add(tab[inc]);
			}
		}
		if(ol.size()>tab.length){
			for(int inc=0; inc<tab.length;inc++){
				now.add(tab[inc]);
			}
			for(String s : ol ){
				if(!now.contains(s)){
					FileEvent c = new FileEvent(s);
					this.check.fireFileRemoved(c);
					old.remove(s);
				}
				
			}
		}
		
		
	}

}

