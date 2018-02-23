package hanoi;
import hanoi.util.*;
import java.util.*;

public class Hanoi{
  private Tower[] Tours;
  private int nbdisc=0;

  public Hanoi(int nb){
      this.nbdisc=nb;
      this.Tours = new Tower[3];

      // Set Hanoi Game
      this.Tours[0]= new Tower(nb);
      this.Tours[1]= new Tower(nb);
      this.Tours[2]= new Tower(nb);
      for (int i=nb;i>0 ;i-- ) {
        Disc d = new Disc(i);
        this.Tours[0].Add(d);
      }
  }

  /** Move a disc from a tower to another one
  * @param Tower from, Tower to
  * @return boolean if the disc can or not be move
  */
  public boolean moveOneDisc(int from, int to){

      if(!this.Tours[from].IsEmpty() && !this.Tours[to].IsFull() && !this.IsComplete()){
        if(!this.Tours[to].IsEmpty()){
          if(this.Tours[from].top().compare(this.Tours[to].top())<0){
            //System.out.println("Disk "+ this.Tours[from].top().getSize() +" from tower " +from);
            Disc d=this.Tours[from].popDisc();
            this.Tours[to].Add(d);
          //  System.out.println(d.getSize());


            //System.out.println("Disk "+ this.Tours[to].top().getSize() +" moved to tower " + to);

          }
          else{
            //System.out.print("Tower "+ from + " -> Tower "+ to + "\n");
          //  System.out.println("erreur Disc: "+this.Tours[to].top().getSize() +" < "+ this.Tours[from].top().getSize());
            return false;
          }
        }
        else{

          //System.out.println("Disk "+ this.Tours[from].top().getSize() +" from tower " +from);
          this.Tours[to].Add(this.Tours[from].popDisc());

          //System.out.println("Disk "+ this.Tours[to].top().getSize() +" moved to tower " + to);
        }
        this.display();
        return true;
      }

      return false;
  }

  /** Check if the last tower is full, and return true if it is.
  *
  * @return boolean
  */
  public boolean IsComplete(){
    return this.Tours[2].IsFull();
  }

  /** Return the number of disc
  *
  * @return int
  */
  public int getNbdisc(){
    return this.nbdisc;
  }


  //Non fonctionnel
  public void solve(int n, int from, int inter, int to){

    if(n==1){
      this.moveOneDisc(from,to);
      System.out.println("Disk 1 move from Tower "+ from + " to Tower "+ to);
    }
    else{
      this.moveOneDisc(from,to);
      solve(n-1,from,to,inter);
      System.out.println("Disk move from Tower "+ from + " to Tower "+ to);
      //solve(n-1,inter,from,to);
    }
    //System.out.println(this.Tours[2].top().getSize());

  }
  public void display(){
    String[] tower1=this.Tours[0].display();
    String[] tower2=this.Tours[1].display();
    String[] tower3=this.Tours[2].display();
    for (int i=0;i<this.nbdisc ;i++ ) {
      System.out.println(tower1[i] + tower2[i] + tower3[i]);
      System.out.println("\n");
    }


  }
}
