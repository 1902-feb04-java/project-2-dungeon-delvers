package DD.entity;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.logging.Property;

@Entity
@Table(name="characters")
public class Character {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="user_id")
	private int playerAccount;
	
	@Column(name="name")
	private String characterName;
	
	@Column(name="cam_id")
	private int campaignId;
	
	@Column(name="hp")
	private int healthPoints;
	
	@Column(name="ac")
	private int armorClass;
	
	@Column(name="dd")
	private int damageDie;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + armorClass;
		result = prime * result + campaignId;
		result = prime * result + ((characterName == null) ? 0 : characterName.hashCode());
		result = prime * result + damageDie;
		result = prime * result + healthPoints;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + playerAccount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (armorClass != other.armorClass)
			return false;
		if (campaignId != other.campaignId)
			return false;
		if (characterName == null) {
			if (other.characterName != null)
				return false;
		} else if (!characterName.equals(other.characterName))
			return false;
		if (damageDie != other.damageDie)
			return false;
		if (healthPoints != other.healthPoints)
			return false;
		if (id != other.id)
			return false;
		if (playerAccount != other.playerAccount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", playerAccount=" + playerAccount + ", characterName=" + characterName
				+ ", campaignId=" + campaignId + ", healthPoints=" + healthPoints + ", armorClass=" + armorClass
				+ ", damageDie=" + damageDie + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPlayerAccount() {
		return playerAccount;
	}

	public void setPlayerAccount(int playerAccount) {
		this.playerAccount = playerAccount;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getDamageDie() {
		return damageDie;
	}

	public void setDamageDie(int damageDie) {
		this.damageDie = damageDie;
	}

	
}