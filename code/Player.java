public abstract class Player{
  
	private int score;
   private ArrayList<Card> hand;
  
   public Player(){
      score = 0;
      this.hand = new ArrayList<Card>();
   }

   public int getSizeHand()
   {
      return hand.size();
   }
  
   public void goFish(){
      this.hand.add(getDeck().remove(0));
   }
  
   public abstract void getCard(Player other);
  
   public int getScore()
   {
      return score;
   }
  
   public void checkPairs()
   {
    
   }

}