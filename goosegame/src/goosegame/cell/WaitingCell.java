package goosegame.cell;
import goosegame.Player;
/**the WaitingCell extends of AbstractCell*/
public class WaitingCell extends AbstractCell{

  protected int compteur;
  protected int waitingTime;

  public WaitingCell(int index,int waitingTime){
      super(index);
      this.waitingTime=waitingTime;
      this.compteur=waitingTime;
  }

  public int bounce(int de){
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    System.out.print("Vous êtes sur case d'attente de: "+ this.waitingTime +" tour(s).\n");
    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    return super.getIndex();  }

  public boolean canBeLeft(){
    if (this.compteur==0){
      return true;
    }
    else{
      System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
      System.out.print("Vous devez encore attendre: "+this.compteur+"tour(s).\n");
      System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
      this.compteur--;
      return false;
    }
  }

  public void setPlayer(Player p){
    super.setPlayer(p);
    this.compteur=this.waitingTime;
  }

}
