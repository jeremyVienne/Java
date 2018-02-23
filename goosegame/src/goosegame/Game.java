package goosegame;
import java.util.*;
import goosegame.*;
import goosegame.cell.*;
import goosegame.util.Input;
/**The Game */
public class Game{

  protected List<Player> thePlayers;
  protected Board board;
  protected int nb_player=2; /* valeur minimale */

  public Game(Board board, int nb){
    this.board=board;
    this.nb_player=nb;
    this.thePlayers= new ArrayList<Player>(); /* creatino des perso, 4 par default ici */

    /*Choix des noms des joueurs*/
    String name ="";
    for (int i =1; i<=this.nb_player ; i++) {
      System.out.print("\nNom du joueur "+ i + ": ");
      name = Input.readString();
      this.thePlayers.add(new Player(name,this.board.getCell(0)));
    }

  }

  /** play the game
  */
  public void play(){ /* deroulement de la partie */
    int compteur = 0;
    while (!this.finish()){
      compteur=(compteur+1)%this.thePlayers.size();
      Player currentPlayer = this.thePlayers.get(compteur);

      this.display("tour de "+currentPlayer.toString());

      if (currentPlayer.getCell().canBeLeft()){ /* si la cellule actuelle du joueur peut etre quittée */
        Cell cell = this.getNewCell(currentPlayer); /* decide de la nouvelle celulle */
        this.move(currentPlayer,cell); /* bouge le joueur */
      }
    }

    /* trie des joueurs dans le tableau selon leur classement de fin */
    this.display("Le gagnant est: " + this.thePlayers.get(compteur).toString() + " !!!!");
    for (int i=0; i<this.thePlayers.size()-1; i++) {
      if ( this.thePlayers.get(i).getCell().getIndex() < this.thePlayers.get(i+1).getCell().getIndex() ){
        Player tmp = this.thePlayers.get(i);
        this.thePlayers.set(i,this.thePlayers.get(i+1));
        this.thePlayers.set(i+1,tmp);
        i=-1;
      }
    }
    /* affichage des classements des joueurs */
    this.display("Classement de tous les joueurs: ");
    for (int i = 0; i<this.thePlayers.size() ; i++) {
      this.display("#"+(i+1)+" "+this.thePlayers.get(i).toString()+"\t\tscore: "+ this.thePlayers.get(i).getCell().getIndex());
    }

  }

  /** return true if the game is finished
  *   @return state of the game
  */
  public boolean finish(){ /* est ce que la partie est terminée ? */
    return this.board.getCell(this.board.getNbOfCells()).isBusy(); /* si la derniere ceullule du plateau de jeu est plaine => un joueur a fini la partie ) */
  }

  /** Give the next cell after the dices throw
  *   @param player the play who throw th dice
  *   @return the new cell where the player have to move
  */
  public Cell getNewCell(Player player){ /* Donne la prochaine cellule apres le lancé de dés */
    int d = player.twoDiceThrow();
    this.display("Vous avez fait: "+ d +".\n");
    int v = player.getCell().getIndex()+d;
    v = normalize(v);
    Cell arr = this.board.getCell(v);
    int pos = normalize(arr.bounce(d));
    this.display("=======================================\n");
    this.display("Déplacement vers la case => "+ pos + "\n");
    this.display("=======================================\n\n");
    return this.board.getCell(pos);

  }

  /** manage the very end of the board and the overtaking of the last cell
  *   @param d the value of dices threw
  *   @return the new cell of the player
  */
  public int normalize(int d){ /* gere la fin du plateau de jeu avec le retour en arriere si on depasse la cellule de fin */

    if (d>this.board.getNbOfCells()){
      int resultat= this.board.getNbOfCells()-(d-this.board.getNbOfCells());
      return resultat;
    }

    return d;
  }

  /** manage to move a player on the board
  *   @param player the player to move
  *   @param targetCell the cell to reach
  */
  public void move(Player player,Cell targetCell){ /* Gere le deplacement d'un joueur */
    Cell oldCell = player.getCell();
    boolean left=player.getCell().canBeLeft();
    if (targetCell.isBusy() && left){
      Player otherPlayer = targetCell.getPlayer();

      player.setCell(targetCell);
      otherPlayer.setCell(oldCell);
      oldCell.setPlayer(otherPlayer);
      targetCell.setPlayer(player);

    }
    else if (left && !targetCell.isBusy()){
      targetCell.setPlayer(player);
      oldCell.free();
      player.setCell(targetCell);

    }
  }

  /** GUI of the current system to print all the message, change here to and ofther GUI only
  *   @param message the message to display
  */
  public void display(String message){
    System.out.print(message+'\n');
  }


}
