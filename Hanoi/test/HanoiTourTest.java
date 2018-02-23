import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.Tower;
import hanoi.util.Disc;

public class HanoiTourTest {

    @Test
    public void testTower(){
        Tower rouge = new Tower(10);
        assertNotNull(rouge);
    }

    @Test
    public void TestAdd(){
      Tower rouge = new Tower(10);
      Disc vert = new Disc(5);
      Disc bleu =new Disc(3);

      rouge.Add(vert);
      assertFalse(rouge.IsEmpty());

      rouge.Add(bleu);
      assertEquals(rouge.top().getSize(),3);

      Disc violet = rouge.popDisc();
      assertEquals(rouge.top().compare(violet),1);


    }

    @Test
    public void Testpop(){
      Tower rouge = new Tower(10);
      Disc vert = new Disc(5);
      rouge.Add(vert);
      rouge.popDisc();
      assertTrue(rouge.IsEmpty());
    }

    @Test
    public void TestIsFull(){
      Tower rouge = new Tower(10);
      assertFalse(rouge.IsFull());
    }

    @Test
    public void TestIsEmpty(){
      Tower rouge = new Tower(10);
      assertTrue(rouge.IsEmpty());
    }

    @Test
    public void TestNbdisc(){
      Tower rouge = new Tower(10);
      assertEquals(rouge.getNbdisc(),10);

    }

    @Test
    public void TestTop(){
      Tower rouge = new Tower(10);
      Disc vert = new Disc(5);
      rouge.Add(vert);
      assertNotNull(rouge.top());
    }


    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(HanoiTourTest.class);
    }
}
