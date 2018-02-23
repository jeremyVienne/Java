package plugin;

public class Listener implements FileListener{

	@Override
	public void fileAdded(FileEvent e) {
		System.out.println("Nouveau .class "+e.getfile_name().substring(0, e.getfile_name().length()-6)+" détécté");
		
	}

	@Override
	public void fileRemoved(FileEvent e) {
		System.out.println(".class "+e.getfile_name().substring(0, e.getfile_name().length()-6)+" supprimé détécté");
	}
	
}
