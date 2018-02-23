package plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PluginFilter implements FilenameFilter{

	/*
	 * It filters the files in the folder and return the file which ends  with .class and implements Plugin
	 * @param dir : the Folder to check in 
	 * @param name : name of the file 
	 * @return True if the file respects the condition specified in the definition and False if not.  
	 * */
	public boolean accept(File dir, String name) {
		if(!name.endsWith(".class")){
			return false;
		}
		else{
			String class_name = name.substring(0, name.length()-6);
			Class<?> c = null;
			Constructor<?> cons= null;
			Object plugin = null;
			
			/* Creation instance plugin */
			try {
				
				c=Class.forName("plugins."+class_name);
				
				//if(!c.isAssignableFrom(Plugin.class)){return false;}
				cons = c.getConstructor();
				plugin = cons.newInstance();}
			catch ( NoClassDefFoundError er) {
				return false;
			}
			catch( ClassNotFoundException er){
				return false;
			}catch(NoSuchMethodException er){
				return false;
			}catch(SecurityException er){
				return false;
			}catch(InstantiationException er){
				return false;
			}catch(IllegalAccessException er){
				return false;
			}catch(IllegalArgumentException er){
				return false;
			}
			catch(InvocationTargetException er){return false;}
			
			
			
		
			/*test des methodes du plugin*/
			
			
			Plugin p = (Plugin) plugin;
			
			try{
				p.transform("test");
				p.getLabel();
				p.helpMessage();
			}catch(Exception e){
				return false;
			}
			

			return true;
		}
	}
}
