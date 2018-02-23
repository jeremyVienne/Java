package plugin;

public interface FileListener extends java.util.EventListener{
	/*
	 * Action to do when  a file is added
	 * @param e : A FileEvent Object
	 * */
	public void fileAdded(FileEvent e);
	
	/*
	 * Action to do when  a file is removed 
	 * @param e : A FileEvent Object
	 * */
	public void fileRemoved(FileEvent e);
}
