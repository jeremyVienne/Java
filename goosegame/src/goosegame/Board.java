package goosegame;
import goosegame.cell.*;
import java.util.*;
/**the Board of the Game*/
public class Board{

  protected final int nbOfCells;

  protected List<Cell> theCells;

  public Board(int nbOfCells){
    this.nbOfCells=nbOfCells; /* +1 car la case 0 n'est pas comprise */
    this.theCells=new ArrayList<Cell>();
    this.initBoard();
  }

  /** Getter to the cell at a specific index
  *   @param index the index we want to get the cell
  *   @return the cell pointed by the index
  */
  public Cell getCell(int index){    return this.theCells.get(index);  }

  /** Getter to the number of cells in the entier board
  *   @return the number of cell on the entier board
  */
  public int getNbOfCells(){    return this.nbOfCells;  }

  /** Intitalise the board with the parameters given earlier
  */
  protected void initBoard(){
    for (int i=0; i<=this.nbOfCells; i++) {
      if (i==0){
        this.theCells.add(new ZeroCell()); /* CASE DE DEPART  0 */
      }
      else if (i%9==0 && i<this.nbOfCells){
        this.theCells.add(new GooseCell(i)); /* CASE DE L'OIE 9 18 27 36 45 54 */
      }
      else if (i==31 || i==52){
        this.theCells.add(new TrapCell(i)); /* CASE PIEGE 31 52 */
      }
      else if (i==19){
        this.theCells.add(new WaitingCell(i,2)); /* CASE D'ATTENTE 19 */
      }
      /* =========== TP CELL ========== */
      else if (i==6){
        this.theCells.add(new TeleportCell(i,12)); /* tp 6 => 12 */
      }
      else if (i==42){
        this.theCells.add(new TeleportCell(i,30)); /* tp 42 => 30 */
      }
      else if (i==58){
        this.theCells.add(new TeleportCell(i,1)); /* tp 58 => 1 */
      }
      /* ########## /TP CELL ############## */
      else {
        this.theCells.add(new NormalCell(i)); /* CASE NORMALE */
      }
    }
  }

}
