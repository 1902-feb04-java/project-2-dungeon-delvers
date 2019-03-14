package monster;

import java.awt.List;

public class Monster {
	String name;
    int damageDice;
    //int str, dex, con, intel, wis, cha;
    int ac, hp;
    //int spe;
    /*HashMap<String, Integer> savingThrows = new HashMap<String, Integer>(); 
    List<string> damageResistances = new List<String>();
    List<string> damageImmunities = new List<String>();
    List<string> conditionalImmunities = new List<String>();
    List<string> languages = new List<String>();
    List<string> senses = new List<String>();
    int exp;
    HashMap<String, String> abilities = new HashMap<String, String>();
    HashMap<String, String> actions = new HashMap<String, String>();*/
	public String getName() {
		return name;
	}
	public Monster(String name, int damageDice, int ac, int hp) {
		super();
		this.name = name;
		this.damageDice = damageDice;
		this.ac = ac;
		this.hp = hp;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamageDice() {
		return damageDice;
	}
	public void setDamageDice(int damageDice) {
		this.damageDice = damageDice;
	}
	public int getAc() {
		return ac;
	}
	public void setAc(int ac) {
		this.ac = ac;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
}
