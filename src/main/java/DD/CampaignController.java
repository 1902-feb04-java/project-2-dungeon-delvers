package DD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import DD.entity.Campaign;
import DD.entity.CampaignsToAccounts;
import DD.entity.Character;
import DD.service.CampaignService;
import DD.service.CampaignsToAccountsService;


@RestController
@RequestMapping("/campaigns")
public class CampaignController {
	@Autowired
	CampaignService cs;
	@Autowired
	CampaignsToAccountsService ctas;
	
	@GetMapping(path="/isDM/{aId}/{cId}")
	public boolean getCharactersByAccount(
			@PathVariable("aId") int aId,
			@PathVariable("cId") int cId) {
		return ctas.isOwner(aId, cId);
	}
	
	@GetMapping(path="/get")
	public Campaign[] getCampaign()
	{
		
		Campaign[] arr = new Campaign[1];
		arr = cs.getCampaigns().toArray(arr);
		return arr;
	}
	@PostMapping(path="/join", consumes="application/json")
	public void joinCampaign(@RequestBody String c)
	{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jn;
		int acc_id;
		int camp_id;
		try {
			jn = mapper.readTree(c);
			acc_id = jn.get("account_id").asInt();
			camp_id = jn.get("campaign_id").asInt();
			System.out.println(acc_id + " " + camp_id);
			if (ctas.contains(acc_id, camp_id)) {
			ctas.addAccountToCampaign(acc_id, camp_id);
			}
		} catch(Exception e)
		{
			e.printStackTrace(System.out);
		}
		
	}
	@PostMapping(path="/edit", consumes="application/json")
    public void editCampaign(@RequestBody String c) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jn;
		CampaignWithOwner cwo = new CampaignWithOwner();
		//IMEncounter jsonEncounter = null;
		try {
			jn = mapper.readTree(c);
			cwo.name = jn.get("name").asText();
			cwo.saveState = jn.get("saveState").asText();
			cwo.id = jn.get("id").asInt();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Campaign camp = new Campaign();
		
		camp.setCampaignName(cwo.name);
		camp.setSaveState(cwo.saveState);
		camp.setid(cwo.id);
		cs.addCampaign(camp);
		System.out.println(camp.toString());
    
    	
	}
	@PostMapping(path="/post", consumes="application/json")
    public void addCampaign(@RequestBody String c) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jn;
		CampaignWithOwner cwo = new CampaignWithOwner();
		//IMEncounter jsonEncounter = null;
		try {
			jn = mapper.readTree(c);
			cwo.owner = jn.get("owner").asInt();
			cwo.name = jn.get("name").asText();
			cwo.saveState = jn.get("saveState").asText();
			cwo.id = jn.get("id").asInt();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Campaign camp = new Campaign();
		
		camp.setCampaignName(cwo.name);
		camp.setSaveState(cwo.saveState);
		camp.setid(cwo.id);
		cs.addCampaign(camp);
		System.out.println(camp.toString());
    	CampaignsToAccounts cta = new CampaignsToAccounts(0,cwo.owner,camp.getid(),true);
    	ctas.addCampaignsToAccounts(cta);
    	
	}
	

	public class CampaignWithOwner {
		public String name;
		public int id=0;
		public int owner;
		public String saveState = "";
		
		public CampaignWithOwner(String name, int id, int owner, String saveState) {
			super();
			this.name = name;
			this.id = id;
			this.owner = owner;
			this.saveState = saveState;
		}

		public CampaignWithOwner() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "CampaignWithOwner [name=" + name + ", id=" + id + ", owner=" + owner + ", saveState= " + saveState + "]";
		}
		
		
		
	}
}
