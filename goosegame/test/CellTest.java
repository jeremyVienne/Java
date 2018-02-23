import org.junit.*;
import static org.junit.Assert.*;

import goosegame.Player;
import goosegame.cell.*;

public class CellTest {

  @Test
  public void test_newCell(){
    Cell c0= new ZeroCell();
    assertNotNull(c0);
    Cell c1= new GooseCell(1);
    assertNotNull(c1);
    Cell c2 = new NormalCell(2);
    assertNotNull(c2);
    Cell c3 = new TeleportCell(3,1);
    assertNotNull(c3);
    Cell c4 = new TrapCell(4);
    assertNotNull(c4);
    Cell c5 = new WaitingCell(5,2);
    assertNotNull(c5);
  }

  @Test
  public void test_SetPlayer(){
    Player p = new Player("toto");
    Cell c = new NormalCell(1);
    c.setPlayer(p);
    assertEquals(c.getPlayer(), p);
  }

  @Test
  public void test_Free(){
    Player p = new Player("toto");
    Cell c = new NormalCell(1);
    c.setPlayer(p);
    c.free();
    assertEquals(c.getPlayer(),null);
  }

  @Test
  public void test_isBusy(){
    Player p = new Player("toto");
    Cell c = new NormalCell(1);
    c.setPlayer(p);
    assertTrue(c.isBusy());
  }

  @Test
  public void test_getIndex(){
    Cell c = new NormalCell(1);
    assertEquals(c.getIndex(),1);
  }

  @Test
  public void test_bounce(){
    Cell c= new GooseCell(1);
    assertEquals(c.bounce(2),3);
  }

  @Test
  public void test_canBeLeft(){
    Cell c1 = new NormalCell(1);
    assertTrue(c1.canBeLeft());

    Cell c2 = new TrapCell(2);
    assertFalse(c2.canBeLeft());

    Cell c3= new WaitingCell(3,2);
    for(int i=0;i<2;i++){
      assertFalse(c3.canBeLeft());
    }

    assertTrue(c3.canBeLeft());
  }

  public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CellTest.class);
    }

}
