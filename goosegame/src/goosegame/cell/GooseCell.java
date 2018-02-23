package goosegame.cell;
import goosegame.Player;
/**the GooseCell extends of AbstractCell*/
public class GooseCell extends AbstractCell{

  public GooseCell(int index){
      super(index);
  }

  public int bounce(int de){
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    System.out.print("Vous êtes sur une case OIE!!!!\n");
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    return super.getIndex()+de;
  }

  public boolean canBeLeft(){    return true;  }



}
