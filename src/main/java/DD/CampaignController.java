package DD;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DD.entity.Campaign;


@RestController
@RequestMapping("/campaigns")
public class CampaignController {

	
	@PostMapping(path="/post", consumes="application/json")
    public void addCharacter(@RequestBody String c) {
    	System.out.println(c);
    	
    	
	}
	public class CampaignWithOwner {
		private Campaign c;
		private int owner;
		public CampaignWithOwner(Campaign c, int owner) {
			super();
			this.c = c;
			this.owner = owner;
		}
		public Campaign getC() {
			return c;
		}
		public void setC(Campaign c) {
			this.c = c;
		}
		public int getOwner() {
			return owner;
		}
		public void setOwner(int owner) {
			this.owner = owner;
		}
		@Override
		public String toString() {
			return "CampaignWithOwner [c=" + c + ", owner=" + owner + "]";
		}
		
	}
}
