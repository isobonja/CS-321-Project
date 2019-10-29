/**
 * Class controlling the main game flow
 *
 * @version 1.0
 */

import java.util.*;

@SuppressWarnings("javadoc")
public class Game{
   
   /**
    * The selected theme of the deck
    */
	private int theme;
   
   /**
    * True if it is the human player's turn
    */
	private boolean isUserTurn;
   
   /**
    * The main card deck
    */
	private ArrayList<Card> deck;
   
   /**
    * The user's voice input represented as a string
    */
	private String input;
   
   /**
    * The user
    */
	private User user;
   
   /**
    * The computer
    */
	private Computer cp;

	
	public Game(int theme){
      //theme is from MainMenu class
		this.theme = theme;
		this.deck = new ArrayList<>();
		this.isUserTurn = true;

		//creates deck of 52 cards
		for (int i=1; i<=52; i++){
			Card c = new Card(this.theme, i%13);
			this.deck.add(c);
		}


		//initializes user and computer objects
		user = new User();
		cp = new Computer();

		//deals 7 cards into each player's hand
		for (int i=0; i<7; i++) {
			user.goFish(this);
			cp.goFish(this);
		}
		gameLoop();
	}

	/**
    * Loops for each turn of the game
    * If a player's hand is empty or the deck is empty, then
    * the game is over
    */ 
	private void gameLoop(){
		while (user.getSizeHand() != 0 && cp.getSizeHand()!= 0 && deck.size() != 0) 
		{
			//game loop
			if(isUserTurn){
				//user turn
				user.getCard(this, cp);
				user.checkPairs();
			}else{
				//comp turn
				cp.getCard(this, user);
				cp.checkPairs();

			}
		}
		if(user.getScore()>=cp.getScore()) {
			return true;
		}
		else {
			return false;
		}
		//ending
	}

   /**
    * Returns the deck
    *
    * @return deck
    */
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
}