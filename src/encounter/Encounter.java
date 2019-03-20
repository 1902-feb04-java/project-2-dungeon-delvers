package encounter;

public class Encounter {

	long id;
	String encounterName;
	
	int campaignId;
	int userId;
	
	String monsters;
	
	Encounter(long eId, String name, int cId, int uId, String mons) {
		this.id = eId;
		this.encounterName = name;
		this.campaignId = cId;
		this.userId = uId;
		this.monsters = mons;
	}

}
