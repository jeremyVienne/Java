package goosegame.cell;
import goosegame.Player;
/**the TrapCell extends of AbstractCell*/
public class TrapCell extends AbstractCell{

  public TrapCell(int index){
      super(index);
  }

  public int bounce(int de){
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    System.out.print("Vous arrivez sur une case pièges (attendez qu'un autre joueur tombe dessus pour pouvoir recommencer a joué).\n");
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    return super.getIndex();
  }

  public boolean canBeLeft(){
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    System.out.print("Le joueur est sur une case piège et ne peut donc se déplacer.\n");
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    return false;  }

}
