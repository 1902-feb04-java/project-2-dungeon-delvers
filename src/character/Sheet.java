package character;

public class Sheet {
	
	String playerAccount;
	String characterName;
	
	int healthPoints;
	int armorClass;
	int damageDie;
	
	Sheet(String account, String name, int hp, int ac, int dd) {
		this.playerAccount = account;
		this.characterName = name;
		this.healthPoints = hp; 
		this.armorClass = ac;
		this.damageDie = dd;
	} 
}


