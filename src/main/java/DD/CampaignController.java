package DD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import DD.entity.Campaign;
import DD.entity.CampaignsToAccounts;
import DD.service.CampaignService;
import DD.service.CampaignsToAccountsService;


@RestController
@RequestMapping("/campaigns")
public class CampaignController {
	@Autowired
	CampaignService cs;
	@Autowired
	CampaignsToAccountsService ctas;
	
	@GetMapping(path="/get")
	public Campaign[] getCampaign()
	{
		
		Campaign[] arr = new Campaign[1];
		arr = cs.getCampaigns().toArray(arr);
		return arr;
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Campaign camp = new Campaign();
		camp.setCampaignName(cwo.name);
		
		cs.addCampaign(camp);
		System.out.println(camp.toString());
    	CampaignsToAccounts cta = new CampaignsToAccounts(0,cwo.owner,camp.getid(),true);
    	ctas.addCampaignsToAccounts(cta);
    	
	}
	public class CampaignWithOwner {
		public String name;
		public int id=0;
		public int owner;
		
		public CampaignWithOwner(String name, int id, int owner) {
			super();
			this.name = name;
			this.id = id;
			this.owner = owner;
		}

		public CampaignWithOwner() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "CampaignWithOwner [name=" + name + ", id=" + id + ", owner=" + owner + "]";
		}
		
		
		
	}
}
