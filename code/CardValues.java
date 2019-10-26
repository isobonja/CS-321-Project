@SuppressWarnings("javadoc")
public enum CardValues {
	ONE 	(1, "ace",		"cat",		"red",		"apple"),
	TWO 	(2, "two",		"dog",		"orange",	"banana"),
	THREE 	(3, "three",	"snake",	"yellow",	"orange"),
	FOUR 	(4, "four",		"monkey",	"green",	"pear"),
	FIVE 	(5, "five",		"pig",		"blue",		"watermelon"),
	SIX 	(6, "six",		"bear",		"purple",	"rasberry"),
	SEVEN 	(7, "seven",	"shark",	"pink",		"blueberry"),
	EIGHT 	(8, "eight",	"bird",		"black",	"coconut"),
	NINE 	(9, "nine",		"duck",		"white",	"pomegranate"),
	TEN 	(10, "ten",		"spider",	"gray",		"pineapple"),
	ELEVEN 	(11, "jack",	"sheep",	"brown",	"strawberry"),
	TWELVE 	(12, "queen",	"lizard",	"rainbow",	"lemon"),
	THIRTEEN(13, "king",	"bee",		"tan",		"cherry");


	private int num;
	private String defaultVal;
	private String animal;
	private String color;
	private String fruit;

	private CardValues(int num, String defaultVal, String animal, String color, String fruit) {
		this.num = num;
		this.defaultVal = defaultVal;
		this.animal = animal;
		this.color = color;
		this.fruit = fruit;
	}
}