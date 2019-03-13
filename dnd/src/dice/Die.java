package dice;

import java.util.concurrent.ThreadLocalRandom;


public class Die {
	public static int roll(int faces) {
		int myRoll = ThreadLocalRandom.current().nextInt(1, faces + 1); // get random int between 1 and number of faces
		return myRoll;
	}
}




