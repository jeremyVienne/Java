import org.junit.*;
import static org.junit.Assert.*;

import goosegame.Game;
import goosegame.Board;
import goosegame.Player;
import goosegame.cell.*;

public class GameTest {


  @Test
  public void test_NewGame(){
    Board b= new Board(63);
    int nb_player=3;
    Game g = new Game(b,nb_player);
    assertNotNull(g);
  }

  @Test
  public void test_Finish(){
    Board b= new Board(63);
    int nb_player=3;
    Game g = new Game(b,nb_player);

    g.play();
    assertTrue(g.finish());
  }

  @Test
  public void test_Normalize(){
    Board b= new Board(63);
    int nb_player=2;
    Game g = new Game(b,nb_player);
    assertEquals(g.normalize(65),61);
  }

  @Test
  public void test_Move(){
    Board b= new Board(63);
    int nb_player=2;
    Game g = new Game(b,nb_player);
    Cell c = b.getCell(40);
    Cell target= b.getCell(50);
    Player p= new Player("Toto", c);
    assertEquals(p.getCell().getIndex(), 40);
    g.move(p, target);
    assertEquals(p.getCell().getIndex(), 50);
  }


  public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(GameTest.class);
    }

}
