package DD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DD.entity.Encounter;
import DD.service.EncounterService;

@RestController
@RequestMapping("/encounters")
public class EncounterController {
	@Autowired
	EncounterService ms;
	
	@GetMapping
	public List<Encounter> getAllEncounters() {
		return ms.getEncounters();
	}
	
	@PostMapping(path="/post", consumes="application/json")
    public String addEncounter(@RequestBody Encounter e) {
    	System.out.println(e.toString());
    	return ms.addEncounter(e);
    	
	}
}