import java.util.*;

@SuppressWarnings("javadoc")
public class Game{

	private int theme;
	private boolean isUserTurn;
	private ArrayList<Card> deck;
	private String input;
	private User user;
	private Computer cp;

	//theme from MainMenu class
	public Game(int theme){
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

	//called from Game constructor 
	private boolean gameLoop(){
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

	public ArrayList<Card> getDeck(){
		return this.deck;
	}
}