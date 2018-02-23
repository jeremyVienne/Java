package plugin;


import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import IHM.Fenetre;

public class UpdatePluginListener implements FileListener{
	private JMenuBar bar;
	private JTextArea text;
	public UpdatePluginListener(Fenetre f){
		
		this.text= f.getTextArea();
		this.bar= f.getJMenuBar();
		
		
	}
	
	@Override
	public void fileAdded(FileEvent e) {
		String name =e.getfile_name().substring(0, e.getfile_name().length()-6);
		JMenuItem tool = new JMenuItem(name);
		tool.setName(name);
		JMenuItem toolhelp = new JMenuItem(name);
		toolhelp.setName(name);
		tool.addActionListener(new Transform(name, this.text));
		toolhelp.addActionListener(new Help(name));
		this.bar.getMenu(1).add(tool);
		this.bar.getMenu(2).add(toolhelp);
		
	}

	@Override
	public void fileRemoved(FileEvent e) {
		String name =e.getfile_name().substring(0, e.getfile_name().length()-6);
		int nb_tools= this.bar.getMenu(1).getItemCount();
		System.out.println("nb tolls: "+nb_tools);
		for(int inc=0; inc<nb_tools; inc++){
			JMenuItem item= this.bar.getMenu(1).getItem(inc);
			if(item.getName().equals(name)){
				System.out.println(item.getName()+ " pos: "+ inc);
				this.bar.getMenu(1).remove(inc);
				this.bar.getMenu(2).remove(inc);
			}
			nb_tools= this.bar.getMenu(1).getItemCount();
		}
		
		
	}

}
