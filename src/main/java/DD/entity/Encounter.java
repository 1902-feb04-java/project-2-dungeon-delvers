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
@Table(name="encounters")
public class Encounter {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String encounterName;
	
	@Column(name="cam_id")
	private int campaignId;
	
	@Column(name="user_id")
	private int userId;

	@Column(name="monsters")
	private String monsters;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + campaignId;
		result = prime * result + ((encounterName == null) ? 0 : encounterName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((monsters == null) ? 0 : monsters.hashCode());
		result = prime * result + userId;
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
		Encounter other = (Encounter) obj;
		if (campaignId != other.campaignId)
			return false;
		if (encounterName == null) {
			if (other.encounterName != null)
				return false;
		} else if (!encounterName.equals(other.encounterName))
			return false;
		if (id != other.id)
			return false;
		if (monsters == null) {
			if (other.monsters != null)
				return false;
		} else if (!monsters.equals(other.monsters))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encounter [id=" + id + ", encounterName=" + encounterName + ", campaignId=" + campaignId + ", userId="
				+ userId + ", monsters=" + monsters + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEncounterName() {
		return encounterName;
	}

	public void setEncounterName(String encounterName) {
		this.encounterName = encounterName;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMonsters() {
		return monsters;
	}

	public void setMonsters(String monsters) {
		this.monsters = monsters;
	}
	
	
}
