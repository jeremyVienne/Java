package hanoi;
import hanoi.Hanoi;
import hanoi.io.HanoiInput;

public class HanoiMain {
    public static void main(String[] args) {
        //Word mot = new Word(args[0]);
        //System.out.println(mot.nbOfChars());
        Hanoi game = new Hanoi(3);
        HanoiInput hinput = new HanoiInput();
        //game.solve(lTower[0],lTower[1],lTower[2]);
        boolean finish=false;
        game.display();
        while(!finish){

          hinput.readInput();

          if(hinput.isMove() && !game.IsComplete()){
            System.out.println("Tower "+ hinput.getFrom() + " -> Tower " + hinput.getTo());
            boolean move =false;
            move = game.moveOneDisc(hinput.getFrom(), hinput.getTo());
            finish=game.IsComplete();
            if(!move){
              game.display();
              System.out.println("Can't be moved");
            }

          }
          else{
            finish=true;
            System.out.println("You quit the Game");
          }




        if(game.IsComplete()){
          System.out.println("Game Complete");
        }
    }

}
}
