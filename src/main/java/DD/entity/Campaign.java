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
@Table(name="campaigns")
public class Campaign {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String campaignName;
	
	@Column(name="save_state")
	private String saveState;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((campaignName == null) ? 0 : campaignName.hashCode());
		result = prime * result + ((saveState == null) ? 0 : saveState.hashCode());
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
		Campaign other = (Campaign) obj;
		if (id != other.id)
			return false;
		if (campaignName == null) {
			if (other.campaignName != null)
				return false;
		} else if (!campaignName.equals(other.campaignName))
			return false;
		if (saveState == null) {
			if (other.saveState != null)
				return false;
		} else if (!saveState.equals(other.saveState))
			return false;
		return true;
	}

	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
		this.id = 0;
		this.saveState = "";
		this.campaignName = "";
	}

	@Override
	public String toString() {
		return "Campaign [id=" + id + ", campaignName=" + campaignName + ", saveState=" + saveState + "]";
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getSaveState() {
		return saveState;
	}

	public void setSaveState(String saveState) {
		this.saveState = saveState;
	}
}

