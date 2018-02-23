package goosegame.cell;
import goosegame.Player;
/**the NormalCell extends of AbstractCell*/
public class NormalCell extends AbstractCell{

  public NormalCell(int index){
      super(index);
  }

  public int bounce(int de){    return super.getIndex();  }

  public boolean canBeLeft(){    return true;  }

}
