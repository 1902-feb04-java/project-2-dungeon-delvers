package DD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Character;
import DD.repository.CharacterRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Character;
import DD.repository.CharacterRepository;

@Service
public class CharacterService {
	@Autowired
	private CharacterRepository cr;

	public CharacterService() {
	}

	public void setCharacterRepository(CharacterRepository cr) {
		this.cr = cr;
	}

	public List<Character> getCharacters() {
		return this.cr.findAll();
	}
	
	public String addCharacter(Character c) {
		return this.cr.saveAndFlush(c).toString();
	}
	public Character[] getCharactersByAccountId(int id)
	{
		return cr.findAllByPlayerAccount(id);
	}
}