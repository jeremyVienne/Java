package ressource;

public class RessourceUser<R extends Ressource> {
	protected R ressource;
	
	/** return the ressource 
	 * @return R ressource
	 * */
	public R getRessource(){
		return this.ressource;
	}
	
	/** set the ressource
	 * @param ressource R
	 */
	public void setRessource(R ressource){
		this.ressource=ressource;
	}
	
	/** reset the ressource to null
	 * 
	 * */
	public void resetRessource(){
		this.ressource=null;
	}
}