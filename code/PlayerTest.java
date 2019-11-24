import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest {

   private Computer cp;
   private User user;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      cp = new Computer();
      user = new User();
   }

   @Test
   public void testGetSizeHand(){
      assertEquals(0, cp.getSizeHand());
   }
   
   @Test
   public void testGetSizeHand2(){
      for(int i = 0; i < 4; i++){
         cp.addToHand(new Card(0, 1));
      }
      assertEquals(4, cp.getSizeHand());
   }
   
   @Test
   public void testGetHand(){
      for(int i = 0; i < 4; i++){
         cp.addToHand(new Card(0, 1));
      }
      assertEquals("[1, 1, 1, 1]", cp.getHand().toString());
   }
   
   @Test
   public void testCheckPairs(){
      for(int i = 0; i < 4; i++){
         cp.addToHand(new Card(0, 1));
      }
      cp.checkPairs();
      assertEquals(0, cp.getSizeHand());
   }
   
   @Test
   public void testCheckPairs2(){
      for(int i = 0; i < 3; i++){
         cp.addToHand(new Card(0, 1));
      }
      cp.checkPairs();
      assertEquals(1, cp.getSizeHand());
   }
   
   @Test
   public void testCheckPairs3(){
      cp.addToHand(new Card(0, 1));
      cp.addToHand(new Card(0, 2));
      cp.addToHand(new Card(0, 3));
      cp.addToHand(new Card(0, 4));
      cp.checkPairs();
      assertEquals(4, cp.getSizeHand());
   }
   
   @Test
   public void testCheckPairs4(){
      cp.addToHand(new Card(0, 11));
      cp.addToHand(new Card(0, 12));
      cp.addToHand(new Card(0, 13));
      cp.addToHand(new Card(0, 13));
      cp.checkPairs();
      assertEquals(2, cp.getSizeHand());
   }
  
   @Test
   public void testCheckPairs5(){
      cp.addToHand(new Card(0, 1));
      cp.addToHand(new Card(0, 2));
      cp.addToHand(new Card(0, 3));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 11));
      cp.addToHand(new Card(0, 12));
      cp.addToHand(new Card(0, 13));
      cp.addToHand(new Card(0, 13));
      cp.checkPairs();
      assertEquals(5, cp.getSizeHand());
   }
   
   @Test
   public void testCheckPairs6(){
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 12));
      cp.addToHand(new Card(0, 13));
      cp.addToHand(new Card(0, 13));
      cp.checkPairs();
      assertEquals(1, cp.getSizeHand());
   }
   
   @Test
   public void testCheckPairsOutOfBounds(){
      for(int i = 0; i < 5; i++){
         cp.addToHand(new Card(0, 1));
      }
      cp.checkPairs();
      assertFalse(1 == cp.getSizeHand());
   }
   
   @Test
   public void testCheckPairsScore(){
      for(int i = 0; i < 4; i++){
         cp.addToHand(new Card(0, 1));
      }
      cp.checkPairs();
      assertEquals(2, cp.getScore());
   }
   
   @Test
   public void testCheckPairsScore2(){
      for(int i = 0; i < 3; i++){
         cp.addToHand(new Card(0, 1));
      }
      cp.checkPairs();
      assertEquals(1, cp.getScore());
   }
   
   @Test
   public void testCheckPairsScore3(){
      cp.addToHand(new Card(0, 1));
      cp.addToHand(new Card(0, 2));
      cp.addToHand(new Card(0, 3));
      cp.addToHand(new Card(0, 4));
      cp.checkPairs();
      assertEquals(0, cp.getScore());
   }
   
   @Test
   public void testCheckPairsScore4(){
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 7));
      cp.addToHand(new Card(0, 12));
      cp.addToHand(new Card(0, 13));
      cp.addToHand(new Card(0, 13));
      cp.checkPairs();
      assertEquals(4, cp.getScore());
   }
   
   @Test
   public void testMultipleCheckPairs(){
      cp.addToHand(new Card(0, 1));
      cp.addToHand(new Card(0, 2));
      cp.addToHand(new Card(0, 2));
      cp.addToHand(new Card(0, 3));
      cp.checkPairs();  //should be 2 cards in hand after
      cp.addToHand(new Card(0, 1));
      cp.addToHand(new Card(0, 6));
      cp.addToHand(new Card(0, 11));
      cp.addToHand(new Card(0, 4));
      cp.checkPairs();  //4 cards
      cp.addToHand(new Card(0, 1));
      cp.addToHand(new Card(0, 13));
      cp.addToHand(new Card(0, 6));
      cp.checkPairs();  //5 cards
      assertEquals(5, cp.getSizeHand());
   }
   
   public void testGetCard(){
      user.addToHand(new Card(0, 1));
      user.addToHand(new Card(0, 2));
      user.addToHand(new Card(0, 3));
      user.addToHand(new Card(0, 4));
      cp.addToHand(new Card(0, 1));
      cp.addToHand(new Card(0, 2));
      cp.addToHand(new Card(0, 3));
      user.getCard(cp, 1, null);
      assertEquals("[2, 3, 4][2, 3]", user.getHand().toString() + cp.getHand().toString());
   }
   
   public void testGetCard2(){
      user.addToHand(new Card(0, 1));
      user.addToHand(new Card(0, 2));
      user.addToHand(new Card(0, 3));
      user.addToHand(new Card(0, 4));
      cp.addToHand(new Card(0, 5));
      cp.addToHand(new Card(0, 6));
      cp.addToHand(new Card(0, 7));
      Card[] cardArr = new Card[1];
      cardArr[0] = new Card(0, 11);
      user.getCard(cp, 1, cardArr);
      assertEquals("[1, 2, 3, 4, 11][5, 6, 7]", user.getHand().toString() + cp.getHand().toString());
   }

}
