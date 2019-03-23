package campaign;

public class Campaign {

	int camId;
	String campaignName;
	String saveState;
	Campaign(int id, String name, String state) {
		this.camId = id;
		this.campaignName = name;
		this.saveState = state;
	}
}