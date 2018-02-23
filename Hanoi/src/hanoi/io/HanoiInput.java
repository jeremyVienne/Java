package hanoi.io;

/**
* Defines a class to read moves for a Hanoi program.<br/>
* It mainly provides the <cdoe>readInput</code> method. This method waits that the user enters a command. This command is a tring that must be a legal move or "quit".
* A legal move is composed of two chars among : <code>'g'</code>, <code>'c'</code>, <code>'d'</code>, e.g. <code>gc</code>. First letter  denotes the source tower (here <code>g</code> for <em>gauche</em> (left)) and second letter (<code>c</code> for <em>center</em>) the destination tower.

<p>Small illustrative code</p>
<pre>
HanoiInput input = new HanoiInput();
input.readInput();     // waits until user gives legal input (= legal move or "quit") )
if (input.isMove()) {
   System.out.prinln("source tower has number "+input.getFrom());
   System.out.prinln("destination tower has number "+input.getTo());
}
else {   // input is "quit"
   System.out.prinln("bye bye");
}
</pre>
* @author yroos
*/
public class HanoiInput {

	// contains a string corresponding to last user's input
    private String lastInput ;

  /** builds an HanoiInput with last input <code>null</code>
  */
  public HanoiInput() {
	this.lastInput = null ;
  }

  /** converts the "name" of a tower to a number
  *@param c the char representing the name of the tower, respectively <code>'g'</code>, <code>'c'</code>, <code>'d'</code>
  * @return the number for this tower, respectively 0, 1, 2
  */
  private static int num(char c) {
		switch(c) {
			case 'g' : return 0 ;
			case 'c' : return 1 ;
			case 'd' : return 2 ;
			default : return - 1 ;
		}
	}


	/**converts into a tower number a char in the move input
      * @param the char number in the input (0 or 1)
      * @return the number for this tower, 0 (left), 1 (center), 2 (right)
    */
    private int numFrom(int i) {
        if (! this.isMove())
            throw new IllegalStateException() ;
  		return HanoiInput.num(this.lastInput.charAt(i)) ;
	}

	/** checks if the given string is a legal input : legal move or "quit"
     a legal move is composed of two chars among : 'g', 'c', 'd'
     @param s the input to be checked
     @return <code>true</code> off the input is legal
     */
  private static boolean isAnInput(String s) {
		if (s == null) return false ;
		if (s.equals("quit")) return true ;
		if (s.length() != 2) return false ;
		return HanoiInput.num(s.charAt(0)) > -1 && HanoiInput.num(s.charAt(1)) > -1 ;
	}

  /** waits until the user provides a legal input (a legal move or <code>"quit"</code>)
  * the input is stored as les "last input"
  */
  public void readInput() {
		String s = null ;
		while (! isAnInput(s)) {
			System.out.print("> ") ;

			s = Input.readString().trim().toLowerCase() ;

			if (! isAnInput(s)) System.out.println("   ?") ;
		}
		this.lastInput = s ;
	}

  /** tells whether last user input is a move or a "quit"
  * @return true iff last input was a move
  */
  public boolean isMove() {
	return ! "quit".equals(this.lastInput) ;
  }

  /** gives the number of the source tower if last input is a move
  * @return the numer  (0, 1 or 2) of the source tower
  * @throws IllegalStateException if last input was not a move
  */
  public int getFrom() {
    return this.numFrom(0) ;
  }

  /** gives the number of the destination tower if last input is a move
  * @return the numer  (0, 1 or 2) of the destination tower
  * @throws IllegalStateException if last input was not a move
  */
  public int getTo() {
     return this.numFrom(1) ;
   }


}
