package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help implements ActionListener{
	private String className;
	/*
	 * Constructor Of the Object Help
	 * @param className : an string which gives us the name of Class  
	 * */
	public Help(String className){
		this.className=className;
	}
	/*
	 * Action to do when we click on the jMenuItem of Help in Menu in the IHM
	 * @param e : an ActionEvent
	 * @exception er  ClassNotFoundException
	 * @exception er NoSuchMethodException
	 * @exception er InvocationTargetException
	 * @exception er IllegalArgumentException
	 * @exception er IllegalAccessException
	 * @exception er InstantiationException
	 * @exception er SecurityException
	 * @exception er NoClassDefFoundError
	 * */
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
		
		JFrame f = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel(p.helpMessage());
		panel.add(label);
		f.add(panel);
		f.setSize(400, 100);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}
}
