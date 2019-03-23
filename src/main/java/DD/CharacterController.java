package DD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DD.entity.Character;
import DD.service.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {
	@Autowired
	CharacterService cs;
	
	@GetMapping
	public List<Character> getAllCharacters() {
		return cs.getCharacters();
	}
	
	@GetMapping(path="/account/{id}")
	public Character[] getCharactersByAccount(@PathVariable("id") int id) {
		return cs.getCharactersByAccountId(id);
	}
	
	@PostMapping(path="/post", consumes="application/json")
    public String addCharacter(@RequestBody Character c) {
    	System.out.println(c.toString());
    	return c.toString();
    	
	}
}