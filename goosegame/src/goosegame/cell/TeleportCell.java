package goosegame.cell;
import goosegame.Player;
/**the TeleportCell extends of AbstractCell*/
public class TeleportCell extends AbstractCell{

  protected int destination;

  public TeleportCell(int index,int destination){
      super(index);
      this.destination=destination;
  }

  public int bounce(int de){
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    System.out.print("Vous êtes sur une case Téléportation ... retour a la case: " + this.destination +"\n");
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    return this.destination;
  }

  public boolean canBeLeft(){    return true;  }

}
