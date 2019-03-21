package DD;

import java.util.concurrent.ThreadLocalRandom;

public class Die {
	public static Integer roll(int faces) {
		Integer myRoll = ThreadLocalRandom.current().nextInt(1, faces + 1); // get random int between 1 and number of faces
		return myRoll;
	}
}