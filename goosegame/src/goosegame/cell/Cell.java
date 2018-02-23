package goosegame.cell;
import goosegame.Player;
/**The Cell interface*/
public interface Cell{

  /** kick out the Player of the current cell
  */
  public void free();
  /** Getter to the player on the cell
  *   @return the player on the cell
  */
  public Player getPlayer();

  /** know if player on cell or not
  * @return true if player on cell, false else
  */
  public boolean isBusy();

  /** check if the cell can be left
  *   @return true if cell can be left now, false else
  */
  public boolean canBeLeft();

  /** Getter to the index ( number ) of the cell on the board
  *   @return the index of the cell on the board
  */
  public int getIndex();

  /** change the dice throw with the cell effect
  *   @param de the dice throw by the player
  *   @return the new value of the dice throw
  */
  public int bounce(int de);

  /** Setter to put a player on the cell
  *   @param p the player to put on the cell
  */
  public void setPlayer(Player p);
}
