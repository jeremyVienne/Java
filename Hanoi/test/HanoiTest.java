import org.junit.*;
import static org.junit.Assert.*;

import hanoi.Hanoi;
import hanoi.util.Tower;


public class HanoiTest {

    @Test
    public void testHanoi(){
      Hanoi rouge = new Hanoi(5);
      assertNotNull(rouge);
    }
    @Test
    public void testGetNbdisc(){
      Hanoi rouge = new Hanoi(5);
      assertEquals(rouge.getNbdisc(),5);
    }

    @Test
    public void testIsComplete(){
      Hanoi rouge = new Hanoi(3);
      rouge.moveOneDisc(0,2);
      rouge.moveOneDisc(0,1);
      rouge.moveOneDisc(2,1);
      rouge.moveOneDisc(0,2);
      rouge.moveOneDisc(1,0);
      rouge.moveOneDisc(1,2);
      rouge.moveOneDisc(0,2);
      assertTrue(rouge.IsComplete());
    }

    @Test
    public void TestMoveOneDisc(){
      Hanoi rouge = new Hanoi(5);
      assertTrue(rouge.moveOneDisc(0,2));

    }

    //methode non fonctionnel
    @Test
    public void TestSolve(){
      Hanoi rouge = new Hanoi(3);
      int n=rouge.getNbdisc();
      rouge.solve(3,0,1,2);
      assertTrue(rouge.IsComplete());
    }




    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(HanoiTest.class);
    }
}
