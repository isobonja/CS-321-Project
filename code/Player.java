/**
 * An abstract class describing a general Player
 *
 * @version 1.0
 */

import java.util.*;

@SuppressWarnings("javadoc")
public class Player{

	/**
	 * A player's score
	 */
	private int score;

	/**
	 * The player's cards
	 */
	protected ArrayList<Card> hand;

	public Player(){
		score = 0;
		this.hand = new ArrayList<Card>();
	}

	/**
	 * Returns the size of the hand
	 *
	 * @return size of hand
	 */    
	public int getSizeHand()
	{
		return hand.size();
	}
   
   public ArrayList<Card> getHand(){
      return hand;
   }

	/**
	 * Draws a card from the main deck and adds it to the
	 * player hand
	 *
	 * @param g the Game
	 */
	public void goFish(Game g){
		int x = (int) (Math.random() * (g.getDeck().size()));
		Card c = g.getDeck().remove(x);
      System.out.println("GO FISH! Drew a " + c.getValue());
      this.hand.add(c);
	}

	/**
	 * Returns the player's score
	 *
	 * @return score
	 */
	public int getScore()
	{
		return score;
	}

	/**
	 * Checks if a pair is present in the player's hand
	 * If it is, the pair is removed and the player's score
	 * is incremented by one
	 */
	public void checkPairs()
	{
		HashMap<Integer, Integer> pairs = new HashMap<>();

		//construct for loop
		for (int i = 0; i < getSizeHand(); i++){
			if (pairs.containsKey(hand.get(i).getValue())){
				pairs.put(hand.get(i).getValue(), pairs.get(hand.get(i).getValue()) +1);
			}
			else{
				pairs.put(hand.get(i).getValue(),1);
			}
		}
      
      //System.out.println(pairs);
      
      if(pairs.containsValue(2) || pairs.containsValue(3) || pairs.containsValue(4)){
         for(int k:pairs.keySet()){
            if(pairs.get(k) >= 2){
               int ct = 0;
               int ctMax = 0;
               if(pairs.get(k)%2 == 0){
                  ctMax = pairs.get(k);
               }else{
                  ctMax = pairs.get(k)-1;
               }
               score += pairs.get(k)/2;
               for(int i = 0; i < this.getSizeHand() && ct < ctMax; i++){
                  if(this.hand.get(i).getValue() == k){
                     this.hand.remove(i);
                     ct++;
                     i--;
                  }
               }
            }
         }
      }
      
      //System.out.println("PAIR MADE!");
      
      
      /*
		ArrayList<Card> duplicateCards = new ArrayList<Card>();
		//loop over hashmap and check which cards are divisble by %2 and then increment score by /2 and adds cards that satisfy condition to list of duplicate cards
		for (Map.Entry<Integer, Integer> entry : pairs.entrySet()){
			if (entry.getValue() % 2 == 0){
				this.score += entry.getValue() / 2;
				duplicateCards.add(entry.getKey());
			}
		}

		//removes all occurences of the duplicated card from the current hand
		this.hand.removeAll(duplicateCards);*/
	}
}
