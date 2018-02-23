package goosegame;
import goosegame.*;
import goosegame.util.Input;
public class Main{
  public static void main(String[] args)  {
      int nb_player =2;
      int nb_cases=63;
      /* choix du nombre de joueurs*/
      do {
        try{
          System.out.print("\nChoix du nombres de joueurs (min 2, max 4): ");
          nb_player=Input.readInt();
        }
        catch(java.io.IOException e){
          System.out.print("Nombre invalide !!! \n");
          nb_player=0;
        }
      } while (nb_player<=1 || nb_player >4);


      Board b = new Board(63);
      Game game =new Game(b, nb_player);

      game.play();

  }
}
