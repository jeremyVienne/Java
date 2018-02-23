package goosegame.cell;
import goosegame.Player;
import java.util.*;
/**the ZeroCell implements of Cell*/
public  class ZeroCell implements Cell{

  protected List<Player> player;
  protected int index;

  public ZeroCell(){
    this.index=0;
    player=new ArrayList<Player>();
  }

  /*ACC*/
  public Player getPlayer(){  return null; }

  public int getIndex(){  return 0;  }

  public void setPlayer(Player playerToSet){  this.player.add(playerToSet);  }
  /*/ACC*/

  public int bounce(int de){    return 0;  }

  public void free(){}

  public boolean isBusy(){    return false;  }

  public boolean canBeLeft(){    return true;  }

}
