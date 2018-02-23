import org.junit.*;
import static org.junit.Assert.*;

import goosegame.Player;
import goosegame.cell.*;

public class PlayerTest {

  @Test
  public void  test_NewPlayer(){
    Cell c = new NormalCell(40);
    Player p = new Player("toto", c);
    assertNotNull(p);
  }

  @Test
  public void test_GetCell(){
    Cell c = new NormalCell(40);
    Player p = new Player("toto", c);
    assertEquals(p.getCell(), c);
  }
  public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
    }

}
