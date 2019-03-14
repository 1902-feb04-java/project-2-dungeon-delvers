package monster;

import monster.Monster;
import dice.DiceFactory;

public class MonsterFactory {
	static Monster Aboleth = new Monster("Aboleth", DiceFactory.d8, 19, 100);
}
