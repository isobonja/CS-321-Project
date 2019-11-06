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

	private Scanner in;


	public Game(int theme){
		//theme is from MainMenu class
		this.theme = theme;
		this.deck = new ArrayList<>();
		this.isUserTurn = true;
		this.in = new Scanner(System.in);

		//creates deck of 52 cards
		for (int i=1; i<=52; i++){
			Card c = new Card(this.theme, (i%13)+1);
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
		cp.checkPairs();
		user.checkPairs();
      
      //game continues while the user hand, the computer hand, and the deck all are not empty
		while (user.getSizeHand() != 0 && cp.getSizeHand()!= 0 && deck.size() != 0) 
		{
			System.out.println("CP SCORE: " + cp.getScore() + "\tUSER SCORE: " + user.getScore() + "\tCARDS IN DECK: " + deck.size());
			//System.out.println("test");
			System.out.println("CP HAND: " + cp.getHand());
			//System.out.println(cp.getSizeHand());
			System.out.println("USER HAND: " + user.getHand());
			//System.out.println(user.getSizeHand());
			if(isUserTurn){
				System.out.println("User's turn:\n");
				System.out.print("Enter the value you would like to ask for: ");
				int value = in.nextInt();
				
				ArrayList<Integer> currentUserCards = new ArrayList<>();
				for(int i = 0; i < user.getHand().size(); i++) {
					currentUserCards.add(user.getHand().get(i).getValue());
				}
				
				//make sure player is asking for a card that they have
				while (currentUserCards.contains(value) == false) {
					System.out.println("\nPlese ask for card you already havve in your own deck!");
					System.out.print("Enter the value you would like to ask for: ");
					value = in.nextInt();
				}
				
				//checks if the card the user selected is in the computer's hand
				user.getCard(this, cp, value);
            
            //checks for pairs in the user's hand
				user.checkPairs();
			}else{
				//comp turn
				System.out.println("Computer's turn:\n");
				cp.getCard(this, user);
				cp.checkPairs();
			}
		}

		System.out.println("User score: " + user.getScore() + "     Computer score: " + cp.getScore());

      //end of game
		if(user.getScore()>cp.getScore()) {
			System.out.println("You win!");
		}else if(cp.getScore()>user.getScore()){
			System.out.println("Computer wins!");
		}else{
			System.out.println("Tie!");
		}
	}

	/**
	 * Returns the deck
	 *
	 * @return deck
	 */
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
   
   /**
    * Changes whose turn it currently is
    *
    * @param b true if it is user's turn and false if it is computer's turn
    */
	public void setTurn(boolean b){
		this.isUserTurn = b;
	}

	public static void main(String[] args){
		new Game(0);
	}
}