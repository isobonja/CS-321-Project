/**
 * A class defining a playing card.
 *
 * @version 1.0
 */

@SuppressWarnings("javadoc")
public class Card{

	private int value;
	private int theme;
	private String image;

	public Card(int theme, int value){
		this.theme = theme;
		this.value = value;
	}
   
   /**
    * Returns the card value
    *
    * @return value
    */
   public int getValue(){
      return this.value;
   }
   
   public String toString(){
      return "" + value;
   }
   
}