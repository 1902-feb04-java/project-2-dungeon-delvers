package DD.im;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import DD.Turn;

public class IMEncounter {
	private List<IMMonster> monsterArray;
	private List<IMCharacter> characterArray;
	private Turn turn;
	
	public IMEncounter() {
		super();
	}
	
	public static IMEncounter fromJSON(String json) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jn;
		IMEncounter jsonEncounter = null;
		try {
			jn = mapper.readTree(json);
			jsonEncounter = mapper.treeToValue(jn, IMEncounter.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonEncounter;
	}

	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void AddMonster(IMMonster newMonster) {
		monsterArray.add(newMonster);
	}
	
	public void RemoveDeadMonsters() {
		for(int i = 0; i<monsterArray.size(); i++) {
			if(monsterArray.get(i).getHp()<=0) {
				monsterArray.remove(i);
			}
		}
	}
	
	public List<IMMonster> getMonsterArray() {
		return monsterArray;
	}
	
	public void setMonsterArray(List<IMMonster> monsterArray) {
		this.monsterArray = monsterArray;
	}

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public List<IMCharacter> getCharacterArray() {
		return characterArray;
	}

	public void setCharacterArray(List<IMCharacter> characterArray) {
		this.characterArray = characterArray;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "IMEncounter [monsterArray="
				+ (monsterArray != null ? monsterArray.subList(0, Math.min(monsterArray.size(), maxLen)) : null)
				+ ", characterArray="
				+ (characterArray != null ? characterArray.subList(0, Math.min(characterArray.size(), maxLen)) : null)
				+ ", turn=" + turn + "]";
	}
}