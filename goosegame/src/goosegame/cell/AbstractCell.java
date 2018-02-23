package goosegame.cell;
import goosegame.Player;
/** Abstract class of Cell */
public abstract class AbstractCell implements Cell{

  protected Player player;
  protected int index;

  public AbstractCell(int index){
    this.index=index;
  }

  /*ACC*/
  public Player getPlayer(){  return this.player; }

  public int getIndex(){  return this.index;  }

  public void setPlayer(Player playerToSet){  this.player = playerToSet;  }
  /*/ACC*/

  public abstract int bounce(int de);

  public abstract boolean canBeLeft();

  public void free(){ player=null;  }

  public boolean isBusy(){  return player!=null;  }

}
