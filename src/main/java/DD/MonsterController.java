package DD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DD.entity.Monster;
import DD.service.MonsterService;

@RestController
@RequestMapping("/monsters")
public class MonsterController {
	@Autowired
	MonsterService ms;
	
	@GetMapping
	public List<Monster> getAllMonsters() {
		return ms.getMonsters();
	}
	
	@PostMapping(path="/post", consumes="application/json")
    public String addMonster(@RequestBody Monster m) {
    	System.out.println(m.toString());
    	return ms.addMonster(m);
    	
	}
}
