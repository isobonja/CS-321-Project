/**
 * A class extending Player specific to the human user
 *
 * @version 1.0
 */

public class User extends Player {

   /**
    * Lets user get a card from the computer
    * 
    * @param g The Game object
    * @param other the Computer player
    */
	public void getCard(Game g, Player other, int value) {
      System.out.println("Checking for card in opponent's hand");
      boolean found = false;
      for(int i = 0; i < other.getSizeHand(); i++){
         if(value == other.getHand().get(i).getValue()){
            System.out.println("Card in opponent's hand!");
            this.hand.add(other.getHand().remove(i));
            found = true;
         }
      }
      
      //card is not in computer's hand
      if(!found){
         System.out.println("Card not in opponent's hand");
         this.goFish(g);
         g.setTurn(false);
      }
	}
   
   
   /**
    * Version of getCard for unit testing
    *
    * @see getCard(Game g, Player other, int value)
    */
   public void getCard(Player other, int value, Card[] cArr) {
      System.out.println("Checking for card in opponent's hand");
      boolean found = false;
      for(int i = 0; i < other.getSizeHand(); i++){
         if(value == other.getHand().get(i).getValue()){
            System.out.println("Card in opponent's hand!");
            this.hand.add(other.getHand().remove(i));
            found = true;
         }
      }
      
      //card is not in computer's hand
      if(!found){
         System.out.println("Card not in opponent's hand");
         this.goFishUser(cArr);
         //g.setTurn(false);
      }
	}
   
   /**
    * Helper method for testing
    *
    * @see Player/goFish(Game g)
    */
   private void goFishUser(Card[] cArr){
		//int x = (int) (Math.random() * (g.getDeck().size()));
		Card c = cArr[0];
      System.out.println("GO FISH! Drew a " + c.getValue());
      this.hand.add(c);
	}
}
