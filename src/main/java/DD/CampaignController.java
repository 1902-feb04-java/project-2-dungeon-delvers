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
    public void addCharacter(@RequestBody Campaign c) {
    	System.out.println(c.toString());
    	
    	
	}
}
