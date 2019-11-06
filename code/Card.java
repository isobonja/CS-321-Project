/**
 * A class defining a playing card.
 *
 * @version 1.0
 */

@SuppressWarnings("javadoc")
public class Card{

   /**
    * A value between 1 and 13 representing the card
    */
	private int value;
   
   /**
    * The theme of the card deck
    */
	private int theme;
   
   /**
    * THe image associated with the card value
    */
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