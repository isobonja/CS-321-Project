/**
 * An abstract class describing a general Player
 *
 * @version 1.0
 */

import java.util.*;

@SuppressWarnings("javadoc")
public abstract class Player{

	/**
	 * A player's score
	 */
	private int score;

	/**
	 * The player's cards
	 */
	private ArrayList<Card> hand;

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

	/**
	 * Draws a card from the main deck and adds it to the
	 * player hand
	 *
	 * @param g the Game
	 */
	public void goFish(Game g){
		int x = (int) (Math.random() * (g.getDeck().size()));
		this.hand.add(g.getDeck().remove(x));
	}

	/**
	 * Abstract class for getting a card from another player
	 *
	 * @param g the Game
	 * @param other the other player
	 */
	public abstract void getCard(Game g, Player other);

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
		HashMap<Card, Integer> pairs = new HashMap<>();

		//construct for loop
		for (int i = 0; i < getSizeHand(); i++){
			if (pairs.containsKey(hand.get(i))){
				pairs.put(hand.get(i), pairs.get(hand.get(i)) +1);
			}
			else{
				pairs.put(hand.get(i),1);
			}
		}

		ArrayList<Card> duplicateCards = new ArrayList<Card>();
		//loop over hashmap and check which cards are divisble by %2 and then increment score by /2 and adds cards that satisfy condition to list of duplicate cards
		for (Map.Entry<Card, Integer> entry : pairs.entrySet()){
			if (entry.getValue() % 2 == 0){
				this.score += entry.getValue() / 2;
				duplicateCards.add(entry.getKey());
			}
		}

		//removes all occurences of the duplicated card from the current hand
		this.hand.removeAll(duplicateCards);
	}
}
