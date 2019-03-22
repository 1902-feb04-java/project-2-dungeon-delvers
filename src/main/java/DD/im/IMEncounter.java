package DD.im;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IMEncounter {
	private List<IMMonster> monsterArray;
	
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
	
	public List<IMMonster> getMonsterArray() {
		return monsterArray;
	}
	
	public void setMonsterArray(List<IMMonster> monsterArray) {
		this.monsterArray = monsterArray;
	}
	
	@Override
	public String toString() {
		return "IMEncounter [monsterArray=" + monsterArray + "]";
	}
}