package DD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Monster;
import DD.repository.MonsterRepository;

@Service
public class MonsterService {
	@Autowired
	private MonsterRepository mr;

	public MonsterService() {
	}

	public void setMonsterRepository(MonsterRepository mr) {
		this.mr = mr;
	}

	public List<Monster> getMonsters() {
		return this.mr.findAll();
	}
	
	public String addMonster(Monster m) {
		return this.mr.saveAndFlush(m).toString();
	}
	public Monster[] getMonstersByAccountId(int id)
	{
		return this.mr.findAllMonstersByAccountId(id);
	}
}

