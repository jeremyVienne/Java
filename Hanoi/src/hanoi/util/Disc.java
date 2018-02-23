package hanoi.util;
public class Disc{
  private int size;

  public Disc(int s){
    size=s;
  }

  /** Return The size of a disc
  *
  * @return int
  */
  public int getSize(){
    return this.size;
  }
  /** Compare a disc with another one
  * @param Disc
  * @return int the result of the comparaison with 2 disc
  */
  public int compare(Disc d){
    if(this.getSize() > d.getSize()){ // si le premier disc > au deuxieme return 1
      return 1;
    }
    else if(this.getSize() < d.getSize()){ // si le deuxieme > au premier return -1
      return -1;
    }
    else{ return 0;} // sinon return 0
  }


  /** compare a disc with an object
  * @param object
  * @return boolean the result of the comparaison between a disc and an object
  */
  public boolean equals(Object o){
    if(o instanceof Disc){
      Disc other = (Disc)o;
      if(this.getSize() == other.getSize())
      {
        return true;
      }
      else{
        return false;
      }
    }
    else{
      return false;
    }
  }

  public String display(){
    String result="|";
    for(int i=0; i<this.getSize();i++){
      result="-"+result;
      result+="-";
    }
    return result;
  }
}
