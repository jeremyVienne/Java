package plugin;

public interface Plugin {
	/*
	 * It transforms the text given in the parameter
	 * @param s : the text to transform
	 * @return the text transformed
	 * */
	public String transform(String s) ;
	/*
	 * It returns the label
	 * @return a String 
	 * */
	public String getLabel() ;
	/*
	 * It returns a message to help
	 * @return a String message 
	 * */
	public String helpMessage();
}
