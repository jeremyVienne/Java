package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JTextArea;

public class Transform implements ActionListener{
	
	private String className;
	private JTextArea text;
	public Transform(String className, JTextArea text){
		this.text = text;
		this.className = className;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Class<?> c = null;
		Constructor<?> cons= null;
		Object plugin = null;
		
		/* Creation instance plugin */
		try {
			
			c=Class.forName("plugins."+this.className);
			
			//if(!c.isAssignableFrom(Plugin.class)){return false;}
			cons = c.getConstructor();
			plugin = cons.newInstance();
		} catch ( NoClassDefFoundError er) {
			
		}
		catch( ClassNotFoundException er){
			
		}catch(NoSuchMethodException er){
			
		}catch(SecurityException er){
			
		}catch(InstantiationException er){
			
		}catch(IllegalAccessException er){
			
		}catch(IllegalArgumentException er){
			
		}
		catch(InvocationTargetException er){}
		
		Plugin p = (Plugin) plugin;
		
		String res = p.transform(this.text.getText());
		this.text.setText(res);
		
	}

}
