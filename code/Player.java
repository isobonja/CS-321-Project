import java.util.*;

@SuppressWarnings("javadoc")
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

	public void goFish(Game g){
		int x = (int) (Math.random() * (g.getDeck().size()));
		this.hand.add(g.getDeck().remove(x));
	}

	public abstract void getCard(Game g, Player other);

	public int getScore()
	{
		return score;
	}

	public void checkPairs()
	{

	}

}