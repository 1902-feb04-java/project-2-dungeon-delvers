package DD.im;

public class IMCharacter {
	private int id;
	private int playerAccount;
	private int campaignId;
	private String name;
	private String type;
	private int damageDie;
	private int ac; 
	private int hp;
	
	public IMCharacter() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayerAccount() {
		return playerAccount;
	}

	public void setPlayerAccount(int playerAccount) {
		this.playerAccount = playerAccount;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
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
		return "IMCharacter [id=" + id + ", playerAccount=" + playerAccount + ", campaignId=" + campaignId + ", name="
				+ name + ", type=" + type + ", damageDie=" + damageDie + ", ac=" + ac + ", hp=" + hp + ", getId()="
				+ getId() + ", getPlayerAccount()=" + getPlayerAccount() + ", getCampaignId()=" + getCampaignId()
				+ ", getName()=" + getName() + ", getType()=" + getType() + ", getDamageDie()=" + getDamageDie()
				+ ", getAc()=" + getAc() + ", getHp()=" + getHp() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
