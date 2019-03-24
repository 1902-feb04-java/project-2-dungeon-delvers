package DD.im;

public class IMMonster {
	private String name;
	private String type;
	private int damageDie;
	private int ac; 
	private int hp;
	
	public IMMonster() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDamageDie() {
		return damageDie;
	}

	public void setDamageDie(int damageDie) {
		this.damageDie = damageDie;
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

	@Override
	public String toString() {
		return "IMMonster [name=" + name + ", type=" + type + ", damageDie=" + damageDie + ", ac=" + ac + ", hp=" + hp
				+ "]";
	}
	
}
