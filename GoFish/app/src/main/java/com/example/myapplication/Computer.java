package com.example.myapplication;

/**
 * A class extending Player specific to the computer
 *
 * @version 1.0
 */
 
public class Computer extends Player {
   private boolean isGoFish = false;

   /**
    * Lets computer get a card from the user
    * 
    * @param g The Game object
    * @param other the human player
    */
	public int getCard(Game g, Player other) {
	  isGoFish = false;
      boolean found = false;
      //System.out.println("Computer choosing a card to ask for");
      int rand = (int)(Math.random()*this.getSizeHand());
      System.out.println("Computer chose " + (this.hand.get(rand).getValue()));
      for(int i = 0; i < other.getSizeHand(); i++){
         System.out.println("" + this.hand.get(rand).getValue() + "\t" + other.getHand().get(i).getValue());
         if(this.hand.get(rand).getValue() == other.getHand().get(i).getValue()){
            System.out.println("Computer's choice is in your hand!");
            this.hand.add(other.getHand().remove(i));
            found = true;
         }
      }
      
      //case for when the card the computer selected is not in the user's hand
      if(!found){
         isGoFish = true;
         System.out.println("Computer's choice is not in your hand!");
         this.goFish(g);
         g.setTurn(true);
      }
      return this.hand.get(rand).getValue();
	}

	public boolean getGoFish(){
	   return isGoFish;
    }

}