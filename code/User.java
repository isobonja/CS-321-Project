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
		// TODO Auto-generated method stub
      System.out.println("Checking for card in opponent's hand");
      boolean found = false;
      for(int i = 0; i < other.getSizeHand(); i++){
         if(value == other.getHand().get(i).getValue()){
            System.out.println("Card in opponent's hand!");
            this.hand.add(other.getHand().remove(i));
            found = true;
         }
      }
      
      if(!found){
         System.out.println("Card not in opponent's hand");
         this.goFish(g);
         g.setTurn(false);
      }
	}
   
   public String printHand(){
      return this.hand.toString();
   }

}
