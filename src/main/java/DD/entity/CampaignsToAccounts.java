package DD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="campaigns_to_accounts")
public class CampaignsToAccounts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="account_id")
	private int accountId;
	@Column(name="campaign_id")
	private int campaignId;
	private boolean dungeon_master;
	
	public CampaignsToAccounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CampaignsToAccounts(int id, int account_id, int campaign_id, boolean dungeon_master) {
		super();
		this.id = id;
		this.accountId = account_id;
		this.campaignId = campaign_id;
		this.dungeon_master = dungeon_master;
	}
	@Override
	public String toString() {
		return "CampaignsToAccounts [id=" + id + ", account_id=" + accountId + ", campaign_id=" + campaignId
				+ ", dungeon_master=" + dungeon_master + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int account_id) {
		this.accountId = account_id;
	}
	public int getCampaign_id() {
		return campaignId;
	}
	public void setCampaign_id(int campaign_id) {
		this.campaignId = campaign_id;
	}
	public boolean isDungeon_master() {
		return dungeon_master;
	}
	public void setDungeon_master(boolean dungeon_master) {
		this.dungeon_master = dungeon_master;
	}
	
}
