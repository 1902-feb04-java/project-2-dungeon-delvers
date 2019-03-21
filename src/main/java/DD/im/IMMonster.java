package DD.im;

public class IMMonster {
	private long id;
	private String name;
	private int damageDie, ac, hp;
	public IMMonster() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "IMMonster [id=" + id + ", name=" + name + ", damageDie=" + damageDie + ", ac=" + ac + ", hp=" + hp
				+ "]";
	}
}
