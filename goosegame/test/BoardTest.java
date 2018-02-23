import org.junit.*;
import static org.junit.Assert.*;

import goosegame.Board;

public class BoardTest {

  @Test
  public void new_Board(){
    Board b= new Board(63);
    assertNotNull(b);
    assertEquals(b.getNbOfCells(),63);
  }

  @Test
  public void Test_getCell(){
    Board b = new Board(63);
    assertNotNull(b.getCell(2));
  }


  public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(BoardTest.class);
    }

}
