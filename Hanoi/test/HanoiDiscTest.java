import org.junit.*;
import static org.junit.Assert.*;
import hanoi.util.Disc;

public class HanoiDiscTest {

    @Test
    public void testDisc(){
      Disc rouge = new Disc(10);

      assertNotNull(rouge);
    }

    @Test
    public void testGetSize(){
      Disc rouge = new Disc(10);

      assertEquals(rouge.getSize(),10);
    }

    @Test
    public void testCompare(){
      Disc rouge = new Disc(10);
      Disc bleu = new Disc(20);
      Disc vert = new Disc(10);

      assertTrue(rouge.compare(vert)==0);
      assertTrue(bleu.compare(rouge)>0);
      assertFalse(vert.compare(bleu)>=0);
    }

    @Test
    public void testEquals(){
      Disc rouge = new Disc(10);
      Disc bleu = new Disc(20);
      Disc vert = new Disc(10);
      String chaine ="test";

      assertTrue(rouge.equals(vert));
      assertFalse(bleu.equals(rouge));
      assertFalse(vert.equals(chaine));
    }


    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(HanoiDiscTest.class);
    }
}
