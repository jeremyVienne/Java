package plugin;
import IHM.*;
public class Main {
	/*
	 * The main class
	 * */
	public static void main(String[] args) {
		PluginFilter c = new PluginFilter(); 
		//FilterclassFile c = new FilterclassFile();
		Fenetre f =new Fenetre();
		//String path= "./repository/plugins";
		
		String path= args[0];
		new FileChecker(c, path, f);		
		
		while(true){}
	}
}
