package com.example.myapplication;

/**
 * A class extending Player specific to the human user
 *
 * @version 1.0
 */

public class User extends Player {
   private boolean isGoFish = false;

   /**
    * Lets user get a card from the computer
    * 
    * @param g The Game object
    * @param other the Computer player
    */
	public void getCard(Game g, Player other, int value) {
	  isGoFish = false;
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
         isGoFish = true;
         System.out.println("Card not in opponent's hand");
         this.goFish(g);
         g.setTurn(false);
      }
	}

	public boolean getGoFish(){
	   return isGoFish;
    }
}
