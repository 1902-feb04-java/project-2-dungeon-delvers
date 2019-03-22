package DD.im;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import DD.Turn;

public class IMEncounter {
	private List<IMMonster> monsterArray;
	private List<IMMonster> tempArray;
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
	
	public void AddMonster(IMMonster newMonster) {
		monsterArray.add(newMonster);
	}
	
	public void RemoveDeadMonsters() {
		for(IMMonster mon : monsterArray) {
			if(mon.getHp()>0) {
				tempArray.add(mon);
			}
		}
		monsterArray = tempArray;
		tempArray.clear();
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

	@Override
	public String toString() {
		final int maxLen = 10;
		return "IMEncounter [monsterArray="
				+ (monsterArray != null ? monsterArray.subList(0, Math.min(monsterArray.size(), maxLen)) : null)
				+ ", turn=" + turn + "]";
	}
}