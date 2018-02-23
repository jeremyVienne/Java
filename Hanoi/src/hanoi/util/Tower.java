package hanoi.util;
import hanoi.util.Disc;
import java.util.*;

public class Tower{
  private List<Disc> Tdisc;
  private int nbdisc=0;
  public Tower (int capacity){
    this.Tdisc=new ArrayList<Disc>(capacity);
    this.nbdisc=capacity;
  }
  /** Add a disc to a tower
  *
  * @param Disc d
  */
  public void Add(Disc d){
    this.Tdisc.add(0,d);
  }

  /** remove a disc from a tower
  *
  * @return Disc
  */
  public Disc popDisc(){
    return this.Tdisc.remove(0);
  }

  /** Return if true if a tower is full
  *
  * @return boolean
  */
  public boolean IsFull(){
    return this.Tdisc.size()==this.nbdisc;
  }

  /** Return true if a tower is Empty
  *
  * @return boolean
  */
  public boolean IsEmpty(){
    return this.Tdisc.size()==0;
  }

  /** Return the number of disc
  *
  * @return int
  */
  public int getNbdisc(){
    return this.nbdisc;
  }

  /** Return the disc from the top of a tower
  *
  * @return disc
  */
  public Disc top(){
    return this.Tdisc.get(0);
  }


  public String[] display() {
    String result="";
    String[] affiche=new String[this.nbdisc];
    int max= (this.nbdisc * 3)+1;
    int inc=0;
    int tower_size=this.Tdisc.size();
    for(int i=0; i<(this.nbdisc-tower_size);i++){
      for (int j=0;j<=max ;j++ ) {
        if(j==max/2){
          result+="|";
        }
        else{
          result+=" ";
        }
      }
      affiche[i]=result;
      result="";
      inc =i;
    }
    for (Disc d : this.Tdisc) {
      result=d.display();
      for(int j=0; j<(max/2)-d.getSize();j++){
        result=" "+result;
        result+=" ";
      }
      affiche[inc]=result;
      inc++;

		}

    if(affiche[2]==null){
      affiche[2]=affiche[1];
      affiche[1]=affiche[0];
      result="";
      for (int j=0;j<=max ;j++ ) {
        if(j==max/2){
          result+="|";
        }
        else{
          result+=" ";
        }
      }
      affiche[0]=result;
    }

    return affiche;
	}
}
